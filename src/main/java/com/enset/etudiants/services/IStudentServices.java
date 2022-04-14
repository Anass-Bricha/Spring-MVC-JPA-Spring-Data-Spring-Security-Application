package com.enset.etudiants.services;

import com.enset.etudiants.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentServices {
    List<Student> studentsList();
    Student saveStudent(Student student);
}
