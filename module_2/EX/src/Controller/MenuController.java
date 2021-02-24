package Controller;

import commons.FuncWriteAndRead;
import model.Xetai;
import service.XetaiManager;

import java.util.List;
import java.util.Scanner;

public class MenuController {
    static FuncWriteAndRead<Xetai> functionReadAndWrite = new FuncWriteAndRead<>();
    static Scanner scanner = new Scanner(System.in);
    static XetaiManager xetaiManager = new XetaiManager();

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int choose;
        do {

            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG");
            System.out.println("1.Thêm mới phương tiện.\n" +
                    "2. Hiện thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát\n");
            System.out.println("Chọn chức năng:");
           choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addPhuongTien();
                    break;
                case 2:
                    showPhuongTien();
                    break;
                case 3:
                    xoaPhuongTien();
                    break;
                case 4:
                    System.exit(choose);
                    break;
                default:
                    System.out.println("Chon 1->4");
            }

        } while (true);
    }


    private static void xoaPhuongTien() {
        System.out.println("1. Hiện thị xe tải.\n" +
                "2. Hiện thị ôtô. \n" +
                "3. Hiện  xe máy.\n");
        System.out.println("Chọn chức năng muon xoa:");

        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
//                List<Xetai> xeTaiList = xetaiManager.findAll();
//                for (int i = 0; i < xeTaiList.size(); i++) {
//                    System.out.println((1 + i) + ". " + xeTaiList.get(i));
//                }
//                System.out.println("chon loai xe tai muon xoa");
//                int iXeTai = Integer.parseInt(scanner.nextLine());
//                    xeTaiList.remove(iXeTai-1);
//                   functionReadAndWrite.writeFile("XeTai.csv",xeTaiList,false);
//                System.out.println("Đã xóa thành công");
//                ----------------------------------------------------------------
                List<Xetai> xeTaiList = xetaiManager.findAll();
                System.out.println("nhập tên sp cần tìm");
                String nameSearch = scanner.nextLine();
                for (Xetai xetai : xeTaiList) {
                    if (xetai.getBienKiemSoat().contains(nameSearch)) {
                        System.out.println(xetai);

                        System.out.println("ban thuc su muon xoa ");
                        System.out.println("1.Yes\n" +
                                "2.No");
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                xeTaiList.remove(xetai);
                                System.out.println("Ban da xoa thanh cong");
                                break;
                            case 2:
                                displayMainMenu();
                                break;
                        }
                        break;
                    }else
                        System.out.println("khong tim thay ban kiem soat");
                }
                functionReadAndWrite.writeFile("XeTai.csv", xeTaiList, false);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private static void showPhuongTien() {
     do{
         System.out.println("1. Hiện thị xe tải.\n" +
                 "2. Hiện thị ôtô. \n" +
                 "3. Hiện  xe máy.\n");
         int choose = Integer.parseInt(scanner.nextLine());
         switch (choose) {
             case 1:
                 showXeTai();
                 break;
             case 2:
                 break;
             case 3:
                 break;
         }
     }while (true);
    }

    private static void showXeTai() {
        List<Xetai> list = xetaiManager.findAll();

        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).showInFor();
        }
    }

    private static void addPhuongTien() {
        System.out.println("1. Thêm xe tải,\n" +
                " \t2. Thêm ôtô, \n" +
                "3. Thêm  xe máy.\n");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                xetaiManager.addXeTai();
                break;
            case 2:
//                addOto();
                break;
            case 3:
//                addXeMay();
                break;
            default:
                System.out.println("Please choice 1->3");
        }
    }

}

