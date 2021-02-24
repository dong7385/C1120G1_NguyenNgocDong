package service;

import commons.FuncWriteAndRead;
import model.LoaiKhach;
import model.VnKhachHang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VnKhachHangManager {
    LoaiKhachManager loaiKhachManager =new LoaiKhachManager();
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<VnKhachHang> functionReadAndWrite = new FuncWriteAndRead<>();

    public void themVnKhachHang() {
        List<VnKhachHang> list = new ArrayList<>();

        System.out.println("Vui long chon ma khach hang");
        String maKhachHang = scanner.nextLine();
        System.out.println("vui ling chon ho ten khach hang");
        String hoten = scanner.nextLine();

        List<LoaiKhach> loaiKhachList = loaiKhachManager.findAll();
        int count = 1;
      System.out.println("Chon loai khach hang  ");
        for (LoaiKhach loaiKhach :loaiKhachList ) {
            System.out.println((count++) + ". " + loaiKhach.getMucDichSuDung());
        }
        int choice = Integer.parseInt(scanner.nextLine());
        String loaiKhachHang=loaiKhachList.get(choice-1).getMucDichSuDung();
        System.out.println("vui long nhap dinh muc ");
        String dinhMucTieuThu=scanner.nextLine();
        VnKhachHang vnKhachHang = new VnKhachHang(maKhachHang, hoten, loaiKhachHang,dinhMucTieuThu);
        list.add(vnKhachHang);
        functionReadAndWrite.writeFile("KhachHang.csv", list, true);
    }

    public List<VnKhachHang> findAll() {
        List<String[]> list = functionReadAndWrite.readFile("KhachHang.csv");
        List<VnKhachHang> vnKhachHangList = new ArrayList<>();
        for (String[] strings : list) {
            VnKhachHang vnKhachHang = new VnKhachHang(strings);
            vnKhachHangList.add(vnKhachHang);
        }
        return vnKhachHangList;
    }
}


