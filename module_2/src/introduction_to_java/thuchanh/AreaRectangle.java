package introduction_to_java.thuchanh;

import java.util.Scanner;

public class AreaRectangle {
    public static void main(String[] args) {
        float width;
        float heigth;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width");
        width = scanner.nextFloat();
        System.out.println("Enter heigth");
        heigth = scanner.nextFloat();

        float area = width * heigth;
        System.out.println("area=  " + area);


    }
}
