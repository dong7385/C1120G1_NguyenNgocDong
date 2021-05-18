package com.student.service;

import com.student.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Page<Student> findAll(Pageable pageable);

    Student findById(Integer id);

    void deleteById(Integer id);

    void save(Student student);


}
