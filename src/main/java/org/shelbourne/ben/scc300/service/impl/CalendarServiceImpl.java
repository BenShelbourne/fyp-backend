package org.shelbourne.ben.scc300.service.impl;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.filter.Filter;
import net.fortuna.ical4j.filter.PeriodRule;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Dur;
import net.fortuna.ical4j.model.Period;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DateProperty;
import org.modelmapper.ModelMapper;
import org.shelbourne.ben.scc300.generated.model.CalendarEvent;
import org.shelbourne.ben.scc300.generated.model.CalendarEventStatus;
import org.shelbourne.ben.scc300.generated.model.CalendarEventType;
import org.shelbourne.ben.scc300.service.AssessmentTrackingService;
import org.shelbourne.ben.scc300.service.AuthenticationFacade;
import org.shelbourne.ben.scc300.service.CalendarService;
import org.springframework.core.io.ClassPathResource;

@org.springframework.stereotype.Component
@Slf4j
public class CalendarServiceImpl implements CalendarService {

    private final AssessmentTrackingService assessmentTrackingService;
    private final AuthenticationFacade authentication;
    private final ModelMapper modelMapper;

    private Calendar calendar;

    @SneakyThrows
    public CalendarServiceImpl(AssessmentTrackingService assessmentTrackingService, ModelMapper modelMapper, AuthenticationFacade authentication) {
        this.authentication = authentication;
        System.setProperty("net.fortuna.ical4j.timezone.cache.impl", "net.fortuna.ical4j.util.MapTimeZoneCache");
        InputStream is = new ClassPathResource("bts-personal.ics").getInputStream();
        CalendarBuilder builder = new CalendarBuilder();
        calendar = builder.build(is);
        this.assessmentTrackingService = assessmentTrackingService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CalendarEvent> getCalendarEvents(LocalDateTime startLocalDate, LocalDateTime endLocalDate) {
        // CalendarEvent event = new CalendarEvent().allDay(true).resource("https:///www.example.com").start(LocalDate.of(2020, 01, 31)).end(LocalDate.of(2020, 02, 03)).title("Hello World");

        if (startLocalDate == null) {
            startLocalDate = LocalDateTime.now().minusDays(1);
        }

        if (endLocalDate == null) {
            endLocalDate = LocalDateTime.now().plusDays(1);
        }

        Long days = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);

        Date startDate = convertToDateViaInstant(startLocalDate.toLocalDate());

        Period period = new Period(new DateTime(startDate.getTime()), new Dur(days.intValue(), 0, 0, 0));
        Filter filter = new Filter(new PeriodRule(period));

        Collection<VEvent> eventsForRange = filter.filter(calendar.getComponents(Component.VEVENT));
        List<CalendarEvent> readOnlyEvents = eventsForRange.stream().map(e -> of(e)).collect(Collectors.toList());
        List<CalendarEvent> assessmentTracking = assessmentTrackingService.getCalendarEventsForUser(authentication.getUsername());
        final LocalDateTime startRange = startLocalDate;
        final LocalDateTime endRange = endLocalDate;
        List filteredAssessments = assessmentTracking.stream().filter(ce -> {
            return startRange.isBefore(ce.getStart()) && endRange.isAfter(ce.getStart());
        }).collect(Collectors.toList());
        readOnlyEvents.addAll(filteredAssessments);
        Collections.sort(readOnlyEvents, Comparator.comparing(CalendarEvent::getStart));
        return readOnlyEvents;
    }

    @Override
    public List<CalendarEvent> getCalendarEventsForLusiWorkId(String lusiWorkId) {
        return assessmentTrackingService.getCalendarEventsForWorkId(lusiWorkId);
    }

    @Override
    public CalendarEvent createCalendarEvent(CalendarEvent calendarEvent) {
        return assessmentTrackingService.addCalendarEvent(calendarEvent);
    }

    @Override
    public CalendarEvent updateCalendarEvent(CalendarEvent calendarEvent) {
        return assessmentTrackingService.addCalendarEvent(calendarEvent);
    }

    private Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant());
    }

    private CalendarEvent of(VEvent vEvent) {
        return new CalendarEvent()
            .title(vEvent.getSummary().getValue())
            .start(from(vEvent.getStartDate()))
            .end(from(vEvent.getEndDate()))
            .eventStatus(CalendarEventStatus.READ_ONLY)
            .location(vEvent.getLocation().getValue())
            .eventType(CalendarEventType.fromValue(vEvent.getDescription().getValue().toUpperCase()));
    }

    private LocalDateTime from(DateProperty vEventDate) {
        return vEventDate.getDate().toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();
    }

//    private String title(VEvent vEvent) {
//        Description description = vEvent.getDescription();
//        return "[" + description.getValue() + "] " + vEvent.getSummary().getValue() + " @ " + vEvent.getLocation().getValue();
//    }
}
