package loop_in_java.thuc_hanh;

import java.util.Scanner;

public class UocChungLonNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số a:  ");
        int a = sc.nextInt();
        System.out.println("hãy nhập so b.csv:  ");
        int b = sc.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0)
            System.out.println("không có ước chung lớn nhất ");
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        System.out.println("Ước chung nhỏ nhất là:  ");
        System.out.println(a);
    }

}

