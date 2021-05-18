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
@RequestMapping("student")
@CrossOrigin(value = "*",allowedHeaders = "*")
public class StudentRestController {
    @Autowired
    StudentService studentService;
    @Autowired
    GroundService groundService;

    @GetMapping("")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Integer id) {
        System.out.println("Fetching Student with id " + id);
        Student student = studentService.findById(id);
        if (student == null) {
            System.out.println("Student with id " + id + " not found");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
   @PostMapping("")
   public ResponseEntity<Void> createBlog(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
       studentService.save(student);
       HttpHeaders headers = new HttpHeaders();
       headers.setLocation(ucBuilder.path("/blogService/{id}").buildAndExpand(student.getId()).toUri());
       return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
   }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateBlog(@PathVariable("id") Integer id, @RequestBody Student student) {
        System.out.println("Updating Blog " + id);
        Student currentStudent = studentService.findById(id);
        if (currentStudent == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        student.setId(id);
        studentService.save(student);
        return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteBlog(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting Blog with id " + id);
        Student student = studentService.findById(id);
        if (student == null) {
            System.out.println("Unable to delete. Blog with id " + id + " not found");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        studentService.deleteById(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }
}
