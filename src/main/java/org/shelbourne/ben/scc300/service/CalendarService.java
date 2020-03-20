package org.shelbourne.ben.scc300.service;

import java.time.LocalDateTime;
import java.util.List;
import org.shelbourne.ben.scc300.generated.model.CalendarEvent;

public interface CalendarService {

    List<CalendarEvent> getCalendarEvents(LocalDateTime startDate, LocalDateTime endDate);
    List<CalendarEvent> getCalendarEventsForLusiWorkId(String lusiWorkId);

    CalendarEvent createCalendarEvent(CalendarEvent calendarEvent);

    CalendarEvent updateCalendarEvent(CalendarEvent calendarEvent);
}
