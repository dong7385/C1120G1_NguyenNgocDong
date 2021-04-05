package com.codegym.demojpa.services;

import com.codegym.demojpa.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    void deleteById(int id);
    void save(Student student);
    List<Student> searchByName(String name);
}
