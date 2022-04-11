package com.enset.etudiants.web;

import com.enset.etudiants.entities.Student;
import com.enset.etudiants.repositories.StudentRepository;
import com.enset.etudiants.services.IStudentServices;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class StudentController {
    private IStudentServices studentServices;
    private StudentRepository studentRepository;
    /*@GetMapping(path="/")
    public String home(){
        return "redirect:/index";
    }*/

   @GetMapping(path="/index")
    public String students(Model model, @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "10") int size,
                           @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Student> studentPages = studentRepository.findByNomContains(keyword, PageRequest.of(page,size));

        model.addAttribute("listStudent",studentPages.getContent());
        model.addAttribute("pages",new int[studentPages.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "students";   //return une vue
    }
}
