package org.shelbourne.ben.scc300.service;

import java.time.LocalDateTime;
import java.util.List;
import org.shelbourne.ben.scc300.generated.model.CalendarEvent;
import org.shelbourne.ben.scc300.generated.model.CourseworkItem;
import org.shelbourne.ben.scc300.repository.AssessmentTrackingRepository;
import org.shelbourne.ben.scc300.repository.model.CalendarEventEntity;

public interface AssessmentTrackingService {

    List<CalendarEvent> getCalendarEventsForWorkId(String losiWorkId);

    List<CalendarEvent> getCalendarEventsForUser(String username);

    List<CalendarEvent> getCalendarEventsForUser();

    CalendarEvent createCalendarEvent(CalendarEventEntity calendarEventEntity);

    CalendarEvent addCalendarEvent(CalendarEvent calendarEvent);

    CalendarEvent upsert(CalendarEvent calendarEvent);

    CourseworkItem completeCoursework(String assessmentProgressId);

    CourseworkItem assessmentFullyCompleted(String lusiWorkId);

    AssessmentTrackingRepository getAssessmentTrackingRepository();

    CourseworkItem startCoursework(String assessmentProgressId);

    CourseworkItem deleteAssessmentTracking(String assessmentProgressId);
}
