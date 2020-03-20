package org.shelbourne.ben.scc300.service.impl;


import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.shelbourne.ben.scc300.exception.ItemNotFoundException;
import org.shelbourne.ben.scc300.generated.model.Student;
import org.shelbourne.ben.scc300.repository.StudentRepository;
import org.shelbourne.ben.scc300.repository.model.StudentEntity;
import org.shelbourne.ben.scc300.service.AuthenticationFacade;
import org.shelbourne.ben.scc300.service.StudentService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final AuthenticationFacade authentication;
    private final ModelMapper modelMapper;

    @Override
    public Student getStudent(String studentId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        if (studentEntity.isPresent()) {
            return modelMapper.map(studentEntity.get(), Student.class);
        } else {
            throw new ItemNotFoundException(String.format("Unknown user %s", studentId));
        }
    }
}
