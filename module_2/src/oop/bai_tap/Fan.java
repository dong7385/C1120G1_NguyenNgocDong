package oop.bai_tap;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.crypto.spec.PSource;

public class Fan {
    final int slow = 1;
    final int medium=2;
    final int fast=3;
    private int speed=slow;
    private boolean on=false;
    private double radius=5;
    private String color="blue";

    public Fan() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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

    public static void main(String[] args) {
        Fan fan1=new Fan();
        fan1.speed=1;
        fan1.radius=10;
        fan1.color="yellow";
        fan1.on=true;
        System.out.println(fan1.toString());
    }

}
