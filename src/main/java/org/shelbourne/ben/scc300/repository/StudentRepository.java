package org.shelbourne.ben.scc300.repository;

import org.shelbourne.ben.scc300.generated.model.Student;
import org.shelbourne.ben.scc300.repository.model.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, String> {

}
