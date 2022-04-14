package com.enset.etudiants.repositories;

import com.enset.etudiants.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    //Page<Student> findByNomContains(String kw, Pageable pageable);
}
