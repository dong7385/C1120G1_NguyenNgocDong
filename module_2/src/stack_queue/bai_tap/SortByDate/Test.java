package stack_queue.bai_tap.SortByDate;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<Student>();
        listStudent.add(new Student("Nguyen Van A", "Nam", "12/12/2001"));
        listStudent.add(new Student("Nguyen Van C", "Nu", "12/1/2005"));
        listStudent.add(new Student("Nguyen Van D", "Nam", "12/12/2008"));
        listStudent.add(new Student("Nguyen Van E", "Nu", "1/12/2001"));
        listStudent.add(new Student("Nguyen Van V", "Nam", "12/12/2019"));
        System.out.println("Truoc khi sort");
        for (Student student : listStudent) {
            System.out.println(student);
        }
        listStudent.sort(new CompareToBirthday());
        Queue<Student> nu = new LinkedList<>();
        Queue<Student> nam = new LinkedList<>();
        for (Student student : listStudent) {
            if (student.getGender().equals("Nam")) {
                nam.add(student);
            }else {
                nu.add(student);
            }
        }
        List<Student>students=new ArrayList<Student>();
        students.addAll(nu);
        students.addAll(nam);

        System.out.println("Sau khi sort");
//        listStudent.sort(new CompareToBirthday());
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
