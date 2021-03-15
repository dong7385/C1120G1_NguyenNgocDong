package repository;

import model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();

    void save(Student student);

    Student findById(int id);

    void remove(int id);
}
