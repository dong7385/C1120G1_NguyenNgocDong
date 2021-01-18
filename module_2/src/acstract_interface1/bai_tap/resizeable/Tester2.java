package acstract_interface1.bai_tap.resizeable;

public class Tester2 {
    public static void main(String[] args) {
//        ResizeableCircle re = new ResizeableCircle(3.6);
//        System.out.println(re);
//        re.resize(20);
//        System.out.println("After-resized (increase 20%):");
//        System.out.println(re);

        Shape2[] shape2s = new Shape2[3];
        shape2s[0] = new Circle2(3.6);
        shape2s[1] = new Rectangle2(3, 5);
        shape2s[2] = new Square2(3.5);

        for (Shape2 shape : shape2s) {
            System.out.println(shape);
            Resizeable resizeableShape;
            if (shape instanceof Circle2) {
                resizeableShape = (Circle2) shape;
            } else //if (shape instanceof Rectangle2) {
                resizeableShape = (Rectangle2) shape;
//            } else {
//                resizeableShape = (Square2) shape;
//            }
            long percent = 1 + Math.round(99 * Math.random());
            resizeableShape.resize(percent);
            System.out.println("After-resized (increase " + percent + "%):");
            System.out.println(resizeableShape);
            System.out.println("=================");
        }
    }
}
