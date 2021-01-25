package exception.bai_tap;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("hãy nhập canh thu 1 tam giác:");
        int a=scanner.nextInt();
        System.out.println("hãy nhập canh thu 2 tam giác:");
        int b=scanner.nextInt();
        System.out.println("hãy nhập canh thu 3 tam giác:");
        int c=scanner.nextInt();
        Triangle triangle=null;
        try {
            triangle=new Triangle(a,b,c);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());

        }
        System.out.println("Kết thúc chương trình"+ triangle);
    }
}
