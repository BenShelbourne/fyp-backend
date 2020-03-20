package org.shelbourne.ben.scc300.repository;

import org.shelbourne.ben.scc300.repository.model.CourseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<CourseEntity, String> {

    //List<CourseEntity> findByStudentId(String studentId);
    //CourseEntity findByCourseworkLusiWorkId(String lusiWorkId);
}
