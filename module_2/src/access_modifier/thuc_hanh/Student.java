package access_modifier.thuc_hanh;

public class Student {
    private int rollno;
    private String name;
    private static String college = "BANDIT";

    //constructor to initialize the variable
    Student(int r, String n) {
        rollno = r;
        name = n;
    }

    //static method to change the value of static variable
    static void change() {
        college = "CODEGEN";
    }

    //method to display values
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
