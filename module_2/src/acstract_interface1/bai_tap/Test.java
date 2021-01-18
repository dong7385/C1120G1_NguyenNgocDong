package acstract_interface1.bai_tap;

import inheritance.thuc_hanh.Circle1;
import inheritance.thuc_hanh.Rectangle;
import inheritance.thuc_hanh.Shape;
import inheritance.thuc_hanh.Square;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Square(5);
        shapes[1] = new Circle1(9);
        shapes[2] = new Rectangle(7, 9);
        for (Shape shape : shapes) {
            System.out.println(shape);
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
                ((Colorable) shape).howToColor();

            }
        }
    }

}
