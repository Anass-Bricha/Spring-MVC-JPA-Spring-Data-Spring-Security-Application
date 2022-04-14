package com.enset.etudiants;

import com.enset.etudiants.entities.Genre;
import com.enset.etudiants.entities.Student;
import com.enset.etudiants.repositories.StudentRepository;
import com.enset.etudiants.services.IStudentServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class EtudiantsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantsApplication.class, args);
    }

/*    @Bean
    CommandLineRunner start(IStudentServices studentServices,StudentRepository studentRepository){
        return args -> {
            Stream.of("anass","amine","hanan","ikram","hicham","ilham","soufiyan").forEach(name->{
                Student student = new Student();
                student.setNom(name);
                student.setPrenom("bricha");
                student.setGenre(Math.random()>0.5? Genre.FEMININ:Genre.MASCULIN);
                student.setEmail(name+"@gmail.com");
                student.setDateNaissance(new Date());
                student.setEnRegle(Math.random()<0.5?false:true);

                studentServices.saveStudent(student);
            });
        };
    }*/

}
