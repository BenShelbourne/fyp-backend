package org.shelbourne.ben.scc300.exception;

import java.util.List;
import org.shelbourne.ben.scc300.generated.model.CalendarEvent;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClashingEventException extends RuntimeException {

    private final List<CalendarEvent> clashingEvents;

    public ClashingEventException(List<CalendarEvent> clashingEvents) {
        super(getMessage(clashingEvents));
        this.clashingEvents = clashingEvents;
    }

    private static String getMessage(List<CalendarEvent> clashingEvents) {
        return "There are clashing events";
    }
}
