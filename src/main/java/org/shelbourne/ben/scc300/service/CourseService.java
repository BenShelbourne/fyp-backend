package org.shelbourne.ben.scc300.service;

import java.util.List;
import org.shelbourne.ben.scc300.generated.model.Course;

public interface CourseService {

    List<Course> getCoursesForStudentId();

    Course getCourse(String courseId);

    Course getCourseForLusiWorkId(String lusiWorkId);
}
