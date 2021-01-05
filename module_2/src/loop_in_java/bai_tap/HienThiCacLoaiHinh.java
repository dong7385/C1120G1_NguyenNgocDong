package loop_in_java.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1 In hình tam giác vuông,có cạnh góc vuông ở dưới");
        System.out.println("2. In hình tam giác vuông,có cạnh góc vuông ở trên ");
        System.out.println("3. In hình chữ nhật");
        System.out.println("4. Exit");
        System.out.println("Vui lòng chọn hình cần vẽ");


        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("nhập cạnh tam giác có cạnh goc vuông ở dưới ");
                    int canhTamGiacCan = sc.nextInt();
                    for (int i = canhTamGiacCan; i > 0; i--) {
                        for (int j = 0; j < i; j++) {
                            System.out.print(" *");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("nhập chiều dài cạnh tam giác vuông có góc vuông ở dưới ");
                    int chieuDaiCanh = sc.nextInt();
                    for (int i = 0; i <= chieuDaiCanh; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print(" *");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("Nhập chiều dài hình chữ nhật");
                    int width = sc.nextInt();
                    System.out.println("Vui lòng chọn chiều rộng hình chữ nhật");
                    int heigth = sc.nextInt();
                    for (int i = 0; i <= width; i++) {
                        for (int j = 0; j <= heigth; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}