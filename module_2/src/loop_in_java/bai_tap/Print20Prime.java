package loop_in_java.bai_tap;

import java.util.Scanner;

public class Print20Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n số nguyên tố đàu tiên");
        int n = sc.nextInt();
        System.out.println(n);
        int count = 0;
        int num = 2;
        while (count <n) {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(num);
                count++;
            }
            num++;
        }
    }
}