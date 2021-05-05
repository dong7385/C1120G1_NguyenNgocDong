package single_responsibility_principle.true_design;

/**
 * Class Formatter nhận nhiệm vụ hiển thị cho student
 */
public class Formatter {
    public String FormatStudentText(Student std) {
        return "Name: " + std.getName() + ". Age: " + std.getAge();
    }
    public String FormatStudentHtml(Student std) {
        return "<span>" + std.getName() + " " + std.getAge() + "</span>";
    }
}
