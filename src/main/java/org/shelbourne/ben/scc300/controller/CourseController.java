package org.shelbourne.ben.scc300.controller;


import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.shelbourne.ben.scc300.generated.controller.CoursesApi;
import org.shelbourne.ben.scc300.generated.model.Course;
import org.shelbourne.ben.scc300.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@Data
@RequiredArgsConstructor
public class CourseController implements CoursesApi {

    private final CourseService courseService;

    @Override
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.ok(courseService.getCoursesForStudentId());
    }

}
