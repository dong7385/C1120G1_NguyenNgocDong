package loop_in_java.thuc_hanh;

import java.util.Scanner;

public class tao_menu_chon_lua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Vẽ hình vuông ");
        System.out.println("2. Vẽ hình tam giác ");
        System.out.println("3. Vẽ hình chữ nhật");
        System.out.println("0. Exit");
        boolean check = false;
        do {
            System.out.print("Vui lòng chọn thông tin cần vẽ :");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("*******");
                    System.out.println("*******");
                    System.out.println("*******");
                    break;
                case 2:
                    System.out.println("*******");
                    System.out.println("******");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 3:
                    System.out.println("*******");
                    System.out.println("*******");
                    System.out.println("*******");
                    System.out.println("*******");
                    System.out.println("*******");
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice");
            }
        } while (!check);


    }
}

