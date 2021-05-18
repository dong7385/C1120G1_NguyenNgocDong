package repository;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {

    private static Map<Integer, Student> studentList;

    static {
        studentList = new HashMap<>();
        studentList.put(1, new Student(1, "Khoa", 1, 90, ""));
        studentList.put(2, new Student(2, "Dong", 1, 100, "avatar_1.jpg"));
        studentList.put(3, new Student(3, "Hong", 0, 50, "avatar_2.png"));
        studentList.put(4, new Student(4, "Hue", 2, 80, "avatar_3.jpg"));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentList.values());
    }

    @Override
    public void save(Student student) {
        studentList.put(student.getId(), student);
    }

    @Override
    public Student findById(int id) {
        return studentList.get(id);
    }

    @Override
    public void remove(int id) {
         studentList.remove(id);
    }
}
