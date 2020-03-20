package org.shelbourne.ben.scc300.controller;

import io.swagger.annotations.ApiParam;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shelbourne.ben.scc300.generated.controller.CalendarApi;
import org.shelbourne.ben.scc300.generated.model.CalendarEvent;
import org.shelbourne.ben.scc300.service.CalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CalendarController implements CalendarApi {

    private final CalendarService calendarService;

    @Override
    public ResponseEntity<List<CalendarEvent>> getCalendarEvents(@Valid LocalDateTime startDate, @Valid LocalDateTime endDate) {
        return ResponseEntity.ok(calendarService.getCalendarEvents(startDate, endDate));
    }

    @Override
    public ResponseEntity<CalendarEvent> postCalendarEvents(@ApiParam(value = "", required = true) @Valid @RequestBody CalendarEvent calendarEvent) {
        return ResponseEntity.ok(calendarService.createCalendarEvent(calendarEvent));
    }

    @Override
    public ResponseEntity<CalendarEvent> putCalendarEvents(@ApiParam(value = "", required = true) @Valid @RequestBody CalendarEvent calendarEvent) {
        return ResponseEntity.ok(calendarService.createCalendarEvent(calendarEvent));
    }
}
