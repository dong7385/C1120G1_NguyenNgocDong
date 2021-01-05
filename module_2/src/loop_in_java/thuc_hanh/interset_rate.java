package loop_in_java.thuc_hanh;

import java.util.Scanner;

public class interset_rate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số tiền bạn muốn gởi:  ");
        double money = sc.nextDouble();
        System.out.println("hãy nhập số tháng gởi ");
        int month = sc.nextInt();
        System.out.println("Hãy nhập số tiền lãi ");
        double interset_rate = sc.nextDouble();

        double total_interset = 0;
        for (int i = 1; i <= month; i++) {
            total_interset +=money * ((interset_rate / 100) / 12 )*month;
        }
        System.out.println(total_interset);

    }
}
