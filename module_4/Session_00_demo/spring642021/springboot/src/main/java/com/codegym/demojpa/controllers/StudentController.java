package com.codegym.demojpa.controllers;

import com.codegym.demojpa.models.Student;
import com.codegym.demojpa.services.StudentService;
import com.codegym.demojpa.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public ModelAndView getHomePage(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("list", "students", studentService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage(Model model){
        model.addAttribute("subjects", subjectService.findAll());
        return new ModelAndView("create", "student", new Student());
    }

    @PostMapping("/create")
    public String saveStudent(Student student){
        studentService.save(student);
        return "redirect:/";
    }
}
