package controller;

import model.NnKhachHang;
import service.NnKhachHangManager;
import service.VnKhachHangManager;

import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    static VnKhachHangManager vnKhachHangManager=new VnKhachHangManager();
    static NnKhachHangManager nnKhachHangManager=new NnKhachHangManager();

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN");
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm mới khách hàng.\n" +
                    "2. Hiện thị thông tin khách hàng\n" +
                    "3. Tìm kiếm khách hàng\n" +
                    "4. Thêm mới hóa đơn\n" +
                    "5. Chỉnh sửa hóa đơn\n" +
                    "6. Hiện thị thông  tin chi tiết hóa đơn\n" +
                    "7. Thoát\n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    themMoiKhachHang();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(choice);
                    break;
                default:
                    System.out.println("Please choice 1->7");
            }
        } while (true);
    }

    private static void themMoiKhachHang() {
        System.out.println("Chọn loai khach hang ");
        System.out.println("1. Thêm khách hàng VN,\n" +
                " \t2. Thêm khách hàng nước ngoài, \n");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                vnKhachHangManager.themVnKhachHang();
                break;
            case 2:
                nnKhachHangManager.themNnKhachHang();
                break;

        }
    }
    }

