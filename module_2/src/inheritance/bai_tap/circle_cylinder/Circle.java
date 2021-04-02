package inheritance.bai_tap.circle_cylinder;

public class Circle {
    private double radius=1;
    private String color="green";

    public Circle() {
    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Ban kinh=" + radius +
                ", Mau='" + color + '\'' +
                '}';
    }
}
