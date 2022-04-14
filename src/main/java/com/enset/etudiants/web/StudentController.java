package com.enset.etudiants.web;

import com.enset.etudiants.entities.Student;
import com.enset.etudiants.repositories.StudentRepository;
import com.enset.etudiants.services.IStudentServices;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    private IStudentServices studentServices;

    public StudentController(IStudentServices studentServices){
        this.studentServices = studentServices;
    }

    @GetMapping(path = "/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping(path = "/index")
    public String students(Model model){
        model.addAttribute("studentList",studentServices.studentsList());
        return "students";
    }


    @GetMapping(path = "/addStudent")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("newStudent",student);
        return "new_student";
    }


    @PostMapping(path = "/saveStudent")
    public String saveStudnet(@ModelAttribute("student") Student student){
        studentServices.saveStudent(student);
        return "redirect:/index";
    }

   /*@GetMapping(path="/index")
    public String students(Model model, @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "10") int size,
                           @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Student> studentPages = studentRepository.findByNomContains(keyword, PageRequest.of(page,size));

        model.addAttribute("listStudent",studentPages.getContent());
        model.addAttribute("pages",new int[studentPages.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "students";   //return une vue
    }*/

/*    @GetMapping(path = "/students")
    public String students(Model model ,
                           @RequestParam(name = "keyword" , defaultValue = "") String kw,
                           @RequestParam(name = "page" , defaultValue = "1") int page,
                           @RequestParam(name = "page_size" , defaultValue = "10") int size){
        Page<Student> studentPages = studentRepository.findByNomContains(kw, PageRequest.of(page,size));
        model.addAttribute("listStudent",studentPages.getContent());
        model.addAttribute("pages",new int[studentPages.getTotalPages()]);
        *//*TODO add pagination on student html*//*
        return "students";
    }*/
}
