package service;

import commons.FuncWriteAndRead;
import model.BenhAnThuong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyBenhAnThuong {
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<BenhAnThuong> funcWriteAndRead = new FuncWriteAndRead();

    public void themBenhAnThuong() {
        List<BenhAnThuong> list = new ArrayList<>();
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
        System.out.print("Nhập phi nam vien :");
        int phiNamVien = Integer.parseInt(scanner.nextLine());
        BenhAnThuong benhAnThuong = new BenhAnThuong(soThutuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, phiNamVien);
        list.add(benhAnThuong);
        funcWriteAndRead.writeFile("medical_records.csv", list, true);
    }

    public List<BenhAnThuong> findAll() {
        List<String[]> list = funcWriteAndRead.readFile("medical_records.csv");
        List<BenhAnThuong> benhAnThuongList = new ArrayList<>();
        for (String[] strings : list) {
            BenhAnThuong benhAnThuong = new BenhAnThuong(strings);
            benhAnThuongList.add(benhAnThuong);
        }
        return benhAnThuongList;
    }

    public void hienThiBenhAnThuong() {
        List<BenhAnThuong> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).hienThiThongTin();
        }
    }

    public BenhAnThuong findById(String maBenhAn) {
        List<BenhAnThuong> list = findAll();
        for (BenhAnThuong benhAnThuong : list) {
            if (benhAnThuong.getMaBenhAn().equals(maBenhAn)) {
                return benhAnThuong;
            }
        }
        return null;
    }

    public void delete(String maBenhAn) {
        List<BenhAnThuong> list = findAll();
        for (BenhAnThuong benhAnThuong : list) {
            if (benhAnThuong.getMaBenhAn().equals(maBenhAn)) {
                list.remove(benhAnThuong);
                funcWriteAndRead.writeFile("medical_records.csv", list, false);
                return;
            }
        }
    }

}
