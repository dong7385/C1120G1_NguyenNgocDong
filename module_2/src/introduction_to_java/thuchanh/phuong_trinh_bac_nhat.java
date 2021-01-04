package introduction_to_java.thuchanh;

import java.util.Scanner;

public class phuong_trinh_bac_nhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cho phuong trinh duoi dang 'a * x + b = 0', hay nhap hang so :");
        System.out.print("nhap a:  ");
        double a = sc.nextDouble();
        System.out.print("nhap b:  ");
        double b = sc.nextDouble();
        System.out.print("nhap c:  ");
        double c = sc.nextDouble();
        if (a != 0) {
            double result = (c - b) / a;
            System.out.println("result =" + result);
        } else if (b == 0) {
            System.out.println("phuong trinh vo so nghiem");
        } else
            System.out.println("Phuong trinh vo nghiem");
    }
}
