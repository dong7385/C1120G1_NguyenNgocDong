package loop_in_java.thuc_hanh;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số bất kì:   ");
        int num = sc.nextInt();
        if (num < 2) {
            System.out.println(num +    "Không phải là số nguyên tố  ");
        } else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(num)) {
                if (num % i == 0) {
                    check = false;
                }
                i++;
            }
            if (check)
                System.out.println(num +   ":là số nguyên tố ");
            else
                System.out.println(num +   ":không phải là số nguyên tố ");
        }
    }
}
