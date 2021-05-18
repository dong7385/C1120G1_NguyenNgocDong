package service;

import commons.FuncWriteAndRead;
import model.BenhAnThuong;
import model.BenhAnVip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyBenhAnVip {
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<BenhAnVip> funcWriteAndRead = new FuncWriteAndRead();

    public void themBenhAnVip() {
        List<BenhAnVip> list = new ArrayList<>();
        System.out.print("Nhập so thu tu benh an:");
        int soThutuBenhAn = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập ma benh an:");
        String maBenhAn = scanner.nextLine();
        System.out.print("Nhập ma benh nhan:");
        String maBenhNhan = scanner.nextLine();
        System.out.print("Nhập ten benh an:");
        String tenBenhNhan = scanner.nextLine();
        System.out.print("Nhập ngay nhap vien:");
        String ngayNhapVien = scanner.nextLine();
        System.out.print("Nhập ngay ra vien:");
        String ngayRaVien = scanner.nextLine();
        System.out.print("Nhập ly do nhap vien :");
        String lyDoNhapVien = scanner.nextLine();
        System.out.print("Nhập loai benh an vip :");
        String loaiVip = scanner.nextLine();
        System.out.print("Nhập thoi han vip :");
        String thoiHanVip = scanner.nextLine();

        BenhAnVip benhAnVip = new BenhAnVip(soThutuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, loaiVip, thoiHanVip);
        list.add(benhAnVip);
        funcWriteAndRead.writeFile("medical_records.csv", list, true);
    }

    public List<BenhAnVip> findAll() {
        List<String[]> list = funcWriteAndRead.readFile("medical_records.csv");
        List<BenhAnVip> benhAnVipList = new ArrayList<>();
        for (String[] strings : list) {
            BenhAnVip benhAnVip = new BenhAnVip(strings);
            benhAnVipList.add(benhAnVip);
        }
        return benhAnVipList;
    }

    public void hienThiBenhAnVip() {
        List<BenhAnVip> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).hienThiThongTin();
        }
    }

    public BenhAnVip findById(String maBenhAn) {
        List<BenhAnVip> list = findAll();
        for (BenhAnVip benhAnVip : list) {
            if (benhAnVip.getMaBenhAn().equals(maBenhAn)) {
                return benhAnVip;
            }
        }
        return null;
    }

    public void delete(String maBenhAn) {
        List<BenhAnVip> list = findAll();
        for (BenhAnVip benhAnVip : list) {
            if (benhAnVip.getMaBenhAn().equals(maBenhAn)) {
                list.remove(benhAnVip);
                funcWriteAndRead.writeFile("medical_records.csv", list, false);
                return;
            }
        }
    }
}
