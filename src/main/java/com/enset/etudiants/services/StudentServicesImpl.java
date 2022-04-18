package com.enset.etudiants.services;

import com.enset.etudiants.entities.Student;
import com.enset.etudiants.repositories.StudentRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        //student.setId(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }


    @Override
    public List<Student> studentsList() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long id){
        this.studentRepository.deleteById(id);
    }

    @Override
    public Student findStudent(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student = null;
        if(optional.isPresent()){
            student = optional.get();
        }else{
            throw new RuntimeException();
        }
        return student;
    }

    @Override
    public List<Student> findStudentBykeyword(String kw) {
        return studentRepository.findByKeyword(kw);
    }
}
