package inheritance.bai_tap.point_moveablepoint;

public class Test {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(6);
        point.setY(5);
        System.out.println(point.toString());

        MovablePoint movablePoint = new MovablePoint(5, 8, 6, 7);
        System.out.println(movablePoint);
//        MovablePoint movablePoint1 = movablePoint.move();
//        System.out.println(movablePoint1);
        movablePoint=movablePoint.move();
        System.out.println(movablePoint);


    }
}
