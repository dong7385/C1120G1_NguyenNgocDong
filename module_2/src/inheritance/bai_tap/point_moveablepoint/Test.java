package inheritance.bai_tap.point_moveablepoint;

public class Test {
    public static void main(String[] args) {
        Point point=new Point();
       point.setX(6);
       point.setY(5);
        System.out.println(point.toString());

        MovablePoint movablePoint=new MovablePoint(5,8);
        System.out.println(movablePoint.toString());
        point.setX(1);
        point.setY(2);
        movablePoint.setXSpeed(6);
        movablePoint.setYSpeed(7);
        System.out.println(movablePoint.move());

        System.out.println(movablePoint.toString());



//        movablePoint.setX(point.getX());
//        movablePoint.setY(point.getX());
//        movablePoint.setXSpeed(4);
//        movablePoint.setYSpeed(9);



    }
}
