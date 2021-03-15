package service;

import model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    Student findById(int id);

    void remove(int id);

//    boolean validateName(String name);
//
//    boolean validateid(int id);
}
