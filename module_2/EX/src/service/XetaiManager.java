package service;

import commons.FuncWriteAndRead;
import model.HangSanXuat;
import model.Xe;
import model.Xetai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XetaiManager {
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<Xetai> functionReadAndWrite = new FuncWriteAndRead<>();
    HangSanXuatManager hangSanXuatManager = new HangSanXuatManager();

    public void addXeTai() {
        String bienKiemSoat;
        String tenHangSanXuat;
        String namSanXuat;
        String chuSanXuat;
        String trongTai;

        List<Xetai> list = new ArrayList<>();

        System.out.println("Nhap ban kiem soat ");
        bienKiemSoat = scanner.nextLine();
//        System.out.println("Nhap ban ten san xuat ");
//        tenHangSanXuat = scanner.nextLine();
        List<HangSanXuat> hangSanXuatList = hangSanXuatManager.findAll();
        int count = 1;
        System.out.println("Chon noi san xuat ");
        for (HangSanXuat hangSanXuat : hangSanXuatList) {
            System.out.println((count++) + ". " + hangSanXuat.getTenSanPham());
        }
        int choice = Integer.parseInt(scanner.nextLine());
        tenHangSanXuat=hangSanXuatList.get(choice-1).getTenSanPham();

        System.out.println("Nhap ban nam san xuat ");
        namSanXuat = scanner.nextLine();
        System.out.println("Nhap chu san xuat ");
        chuSanXuat = scanner.nextLine();
        System.out.println("Nhap chu trong tai ");
        trongTai = scanner.nextLine();
        Xetai xetai = new Xetai(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSanXuat, trongTai);
        list.add(xetai);
        functionReadAndWrite.writeFile("XeTai.csv", list, true);
    }

    public List<Xetai> findAll() {
        List<String[]> list = functionReadAndWrite.readFile("XeTai.csv");
        List<Xetai> xetaiList = new ArrayList<>();
        for (String[] strings : list) {
            Xetai xetai = new Xetai(strings);
            xetaiList.add(xetai);
        }
        return xetaiList;
    }
}
