package org.shelbourne.ben.scc300.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.shelbourne.ben.scc300.service.AssessmentTrackingService;
import org.shelbourne.ben.scc300.service.impl.TokenVerificationServiceImpl;


@ExtendWith(MockitoExtension.class)
class AssessmentControllerTest {

    @Mock
    private AssessmentTrackingService mockAssessmentTrackingService;

    private TokenVerificationServiceImpl tokenVerificationService;
    private AssessmentController controller;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //controller = new AssessmentController(mockAssessmentService,tokenVerificationService);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void getAssessmentForCourse() {
//        Assessment Assessment = new Assessment().courseId("c1").name("T1 Assessment").id("t1");
//        when(mockAssessmentService.getAssessmentsForCourse("c1")).thenReturn(Arrays.asList(Assessment));
//        ResponseEntity<List<Assessment>> response = controller.getAssessmentForCourse("c1");
//        assertNotNull(response);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(1, response.getBody().size());
    }

    @org.junit.jupiter.api.Test
    void getAssessmentProgressForCourse() {
    }

    @org.junit.jupiter.api.Test
    void updateAssessmentForCourse() {
    }
}