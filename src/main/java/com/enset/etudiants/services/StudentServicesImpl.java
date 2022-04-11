package com.enset.etudiants.services;

import com.enset.etudiants.entities.Student;
import com.enset.etudiants.repositories.StudentRepository;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Data
public class StudentServicesImpl implements IStudentServices{
    private StudentRepository studentRepository;

    public StudentServicesImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student saveStudent(Student student) {
        student.setId(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }

}
