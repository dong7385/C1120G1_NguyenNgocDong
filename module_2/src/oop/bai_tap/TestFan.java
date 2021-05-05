package oop.bai_tap;

public class TestFan {
    public static void main(String[] args) {
        Fan fan1=new Fan();
        System.out.println(fan1.toString());
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println(fan1.toString());
    }
}
