package org.shelbourne.ben.scc300.controller;

import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shelbourne.ben.scc300.generated.controller.AssessmentApi;
import org.shelbourne.ben.scc300.generated.model.CalendarEvent;
import org.shelbourne.ben.scc300.generated.model.CourseworkItem;
import org.shelbourne.ben.scc300.service.AssessmentTrackingService;
import org.shelbourne.ben.scc300.service.impl.TokenVerificationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequiredArgsConstructor
@Slf4j
public class AssessmentController implements AssessmentApi {

    private final AssessmentTrackingService assessmentTrackingService;
    private final TokenVerificationServiceImpl tokenVerificationService;

    @Override
    public ResponseEntity<CourseworkItem> assessmentFullyCompleted(String lusiWorkId) {
        return ResponseEntity.ok(assessmentTrackingService.assessmentFullyCompleted(lusiWorkId));
    }

    @Override
    public ResponseEntity<CourseworkItem> completeAssessment(String assessmentProgressId) {
        return ResponseEntity.ok(assessmentTrackingService.completeCoursework(assessmentProgressId));

    }

    @Override
    public ResponseEntity<CourseworkItem> deleteAssessmentTracking(String assessmentProgressId) {
        return ResponseEntity.ok(assessmentTrackingService.deleteAssessmentTracking(assessmentProgressId));
    }

    @Override
    public ResponseEntity<CourseworkItem> startAssessmentCalendarEvent(String assessmentProgressId) {
        return ResponseEntity.ok(assessmentTrackingService.startCoursework(assessmentProgressId));
    }

    @Override
    public ResponseEntity<CalendarEvent> updateAssessmentProgressForAssessment(@ApiParam(value = "ID of Assessment", required = true) @PathVariable("assessment-progress-id") String assessmentProgressId,
        @ApiParam(value = "", required = true) @Valid @RequestBody CalendarEvent assessmentTracking) {
        assessmentTracking.setId(assessmentProgressId);
        return ResponseEntity.ok(assessmentTrackingService.addCalendarEvent(assessmentTracking));
    }
}
