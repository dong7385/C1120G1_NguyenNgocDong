package inheritance.bai_tap.circle_cylinder;

import inheritance.bai_tap.circle_cylinder.Circle;

public class Cylinder extends Circle {
private double height=1;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }
    public double getTheTich(){
        return getArea()*height;
    }
    @Override
    public String toString() {
        return "The tich hinh tru=  "+getArea()+"chieu cao=  " +height;
    }
}
