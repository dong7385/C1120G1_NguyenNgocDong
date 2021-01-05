package loop_in_java.bai_tap;

import java.util.Scanner;

public class hien_thi_so_nguyen_to_nho_hon_100 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num = 2;
        while (num <100) {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(num);
            }
            num++;
        }
    }
}
