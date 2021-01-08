package oop.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    private  double width;
    private  double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String getDisplay() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the width");
        double width = sc.nextDouble();
        System.out.println("Enter the height");
        double height = sc.nextDouble();
        Rectangle rectangle=new Rectangle(width,height);
        System.out.println("dien tich"+rectangle.getArea());
        System.out.println("chu vi "+rectangle.getPerimeter());
        System.out.println("display"+rectangle.getDisplay());
    }



}
