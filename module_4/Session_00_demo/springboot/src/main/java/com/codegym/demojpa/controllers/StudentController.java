package com.codegym.demojpa.controllers;

import com.codegym.demojpa.models.Student;
import com.codegym.demojpa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ModelAndView getHomePage(){
        List<Student> studentsByName = studentService.searchByName("Tr");
        return new ModelAndView("list", "students", studentService.findAll());
    }

}
