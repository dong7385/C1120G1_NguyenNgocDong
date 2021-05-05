package map.thuc_hanh;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapAndHashSet {
    public static void main(String[] args) {
        Student student1 = new Student("Nam", 20, "HN");
        Student student2 = new Student("Hung", 21, "HN");
        Student student3 = new Student("Ha", 22, "HN");
        Map<Integer,Student>integerStudentMap=new HashMap<Integer, Student>();
        integerStudentMap.put(1,student1);
        integerStudentMap.put(2,student2);
        integerStudentMap.put(3,student3);
        integerStudentMap.put(4,student1);
        for (Map.Entry<Integer,Student>student:integerStudentMap.entrySet()){{
            System.out.println(student.toString());
        }}
        System.out.println("-----------------------");
        Set<Student> studentSet=new HashSet<Student>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        for (Student student:studentSet){
            System.out.println(student.toString());
        }}
    }

