package service;

import commons.FuncWriteAndRead;

import model.HangSanXuat;
import model.XeTai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyXeTai {
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<XeTai> funcWriteAndRead = new FuncWriteAndRead();
    static QuanLyHang quanLyHang = new QuanLyHang();


    public void themXeTai() {

        List<XeTai> list = new ArrayList<>();
        System.out.print("Nhập biển kiểm soát:");
        String bienKiemSoat = scanner.nextLine();

        List<HangSanXuat> hangSanXuatList = quanLyHang.findAll();
        int count = 1;
        System.out.println("Chon noi san xuat ");
        for (HangSanXuat hangSanXuat : hangSanXuatList) {
            System.out.println((count++) + ". " + hangSanXuat.getTenHangSanXuat());
        }
        int choice = Integer.parseInt(scanner.nextLine());
        String tenHang=hangSanXuatList.get(choice-1).getTenHangSanXuat();

                System.out.print("Nhập năm sản xuất: ");
        String namSanXuat = scanner.nextLine();
        System.out.print("Nhập chủ sở hữu :");
        String chuSoHuu = scanner.nextLine();
        System.out.print("Nhập trọng tải: ");
        int trongTai = Integer.parseInt(scanner.nextLine());
        XeTai xeTai=new XeTai(bienKiemSoat,tenHang,namSanXuat,chuSoHuu,trongTai);
        list.add(xeTai);
        funcWriteAndRead.writeFile("XeTai.csv", list, true);
    }

    public List<XeTai> findAll() {
        List<String[]> list = funcWriteAndRead.readFile("XeTai.csv");
        List<XeTai> xetaiList = new ArrayList<>();
        for (String[] strings : list) {
            XeTai xetai = new XeTai(strings);
            xetaiList.add(xetai);
        }
        return xetaiList;
    }

    public void hienThiXeTai() {
        List<XeTai> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).hienThiThongTin();
        }
    }

    public XeTai findById(String bienKiemSoat) {
        List<XeTai> list = findAll();
        for (XeTai xeTai : list) {
            if (xeTai.getBienKiemSoat().equals(bienKiemSoat)) {
                return xeTai;
            }
        }
        return null;
    }

    public void delete(String bienKiemSoat) {
        List<XeTai> list = findAll();
        for (XeTai xeTai : list) {
            if (xeTai.getBienKiemSoat().equals(bienKiemSoat)) {
                list.remove(xeTai);
                funcWriteAndRead.writeFile("XeTai.csv", list, false);
                return;
            }
        }
    }

    public void edit(XeTai xeTai, String bienKiemSoat) {
        List<XeTai> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBienKiemSoat().equals(bienKiemSoat)) {
                list.remove(i);
                list.add(i, xeTai);
                funcWriteAndRead.writeFile("XeTai.csv", list, false);
                return;
            }
        }
    }
}