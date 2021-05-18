package stack_queue.thuc_hanh.comparator;

import java.util.*;
public class ComparatorTest {
    public static void main(String[] args) {
        List<Student> listStudents = new ArrayList<Student>();
        listStudents.add(new Student(1, "Vinh", 19, "Hanoi"));
        listStudents.add(new Student(2, "Hoa", 24, "Hanoi"));
        listStudents.add(new Student(3, "Hoa", 20, "Hanoi"));
        listStudents.add(new Student(4, "Quy", 22, "Hanoi"));
        listStudents.sort(new StudentComparatorByName());
        for (Student student : listStudents) {
            System.out.println(student);
        }
    }
}

