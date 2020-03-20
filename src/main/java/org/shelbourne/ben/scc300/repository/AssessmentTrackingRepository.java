package org.shelbourne.ben.scc300.repository;

import java.util.List;
import org.shelbourne.ben.scc300.repository.model.CalendarEventEntity;
import org.shelbourne.ben.scc300.repository.model.CourseworkItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface AssessmentTrackingRepository extends CrudRepository<CalendarEventEntity, String> {

    List<CalendarEventEntity> findByLusiWorkId(String lusiWorkId);
    List<CalendarEventEntity> findByLusiWorkIdAndUsername(String lusiWorkId, String username);
    List<CalendarEventEntity> findByUsername(String username);

    //Assessment updateAssessmentById(String AssessmentId, AssigmentProgress progress);

}
