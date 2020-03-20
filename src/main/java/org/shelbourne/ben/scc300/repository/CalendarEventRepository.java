package org.shelbourne.ben.scc300.repository;

import org.shelbourne.ben.scc300.repository.model.CalendarEventEntity;
import org.springframework.data.repository.CrudRepository;

public interface CalendarEventRepository extends CrudRepository<CalendarEventEntity, String> {

    //List<CourseEntity> findByStudentId(String studentId);
}
