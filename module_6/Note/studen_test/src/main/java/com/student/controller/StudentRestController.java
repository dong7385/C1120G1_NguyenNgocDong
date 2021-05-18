package com.student.controller;

import com.student.model.Student;
import com.student.service.GroundService;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(value = "*",allowedHeaders = "*")
public class StudentRestController {
    @Autowired
    StudentService studentService;
    @Autowired
    GroundService groundService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listAllBlog() {
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getBlog(@PathVariable("id") Integer id) {
        System.out.println("Fetching Student with id " + id);
        Student student = studentService.findById(id);
        if (student == null) {
            System.out.println("Student with id " + id + " not found");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    @RequestMapping(value = "/student/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlog(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Student " + student.getName());
        studentService.save(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/student/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
