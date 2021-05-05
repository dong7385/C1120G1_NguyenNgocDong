package acstract_interface1.bai_tap.resizeable;

import acstract_interface1.bai_tap.Colorable;

public class Square2 extends Rectangle2 implements Colorable {

    public Square2() {
    }

    public Square2(double side) {
        super(side, side);
    }

    public Square2(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
    }

    public Square2(double v, String yellow, boolean b) {
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);

    }
    public double getArea() {
        return this.getSide()*this.getSide();
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");

    }

//    @Override
//    public void resize(double percent) {
//        setSide(getSide() * (1 + percent / 100));
//    }

}
