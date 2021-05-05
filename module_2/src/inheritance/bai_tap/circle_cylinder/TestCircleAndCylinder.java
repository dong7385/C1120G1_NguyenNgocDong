package inheritance.bai_tap.circle_cylinder;

        import inheritance.bai_tap.circle_cylinder.Circle;
        import inheritance.bai_tap.circle_cylinder.Cylinder;

public class TestCircleAndCylinder {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(4.5, "red");
        System.out.println(circle);
        System.out.println("dien tich hinh tron="+circle.getArea());
        Cylinder cylinder=new Cylinder();
        System.out.println(cylinder);
        System.out.println("the tich hinh tru ="+cylinder.getTheTich());
    }
}
