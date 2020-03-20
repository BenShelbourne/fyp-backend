package org.shelbourne.ben.scc300.repository;

import java.util.List;
import org.shelbourne.ben.scc300.repository.model.CourseworkItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseworkItemRepository extends CrudRepository<CourseworkItemEntity, String> {

    List<CourseworkItemEntity> findByLusiCourseId(String lusiCourseId);
    CourseworkItemEntity findByLusiWorkId(String lusiWorkId);
}
