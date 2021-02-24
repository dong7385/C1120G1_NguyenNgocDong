package controller;

import service.QuanLyBenhAnThuong;
import service.QuanLyBenhAnVip;

import java.util.Scanner;

public class MenuController {
    static Scanner scanner = new Scanner(System.in);

    static QuanLyBenhAnThuong quanLyBenhAnThuong = new QuanLyBenhAnThuong();
    static QuanLyBenhAnVip quanLyBenhAnVip = new QuanLyBenhAnVip();

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {

        do {
            System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN\n"
                    + "1. Thêm mới\n"
                    + "2. Xóa\n"
                    + "3. Xem danh sách bệnh án \n"
                    + "4. Thoát\n"

                    + "Chọn chức năng:\n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    themMoi();
                    break;
                case "2":
                    xoa();
                    break;
                case "3":
                    xemDanhSachBenhAn();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 3");
            }

        } while (true);

    }

    public static void xoa() {
    }

    private static void xemDanhSachBenhAn() {
        System.out.println("\nChọn chức năng xem danh sach benh nhan:\n"
                + "1. Hiển thị benh an thuong\n"
                + "2. Hiển thị benh an vip\n");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                quanLyBenhAnThuong.hienThiBenhAnThuong();
                break;
            case "2":
                quanLyBenhAnVip.hienThiBenhAnVip();
                break;
        }
    }


    private static void themMoi() {
        System.out.println("\nChọn chức năng:\n"
                + "1. Thêm moi benh an thuong \n"
                + "2. Thêm moi benh an vip\n"
                + "3. Thoát");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                quanLyBenhAnThuong.themBenhAnThuong();
                break;
            case "2":
                quanLyBenhAnVip.themBenhAnVip();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Vui lòng chọn từ 1 đến 2");
        }
    }
}
