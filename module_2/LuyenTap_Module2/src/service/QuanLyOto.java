package service;

import commons.FuncWriteAndRead;
import model.Oto;
import model.XeTai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyOto {
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<Oto> funcWriteAndRead = new FuncWriteAndRead();

    public void themOto() {

        List<Oto> list = new ArrayList<>();
        System.out.print("Nhập biển kiểm soát:");
        String bienKiemSoat = scanner.nextLine();
        System.out.print("Nhập tên hàng:");
        String tenHang = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        String namSanXuat = scanner.nextLine();
        System.out.print("Nhập chủ sở hữu: ");
        String chuSoHuu = scanner.nextLine();
        System.out.print("Nhập số chỗ ngồi :  ");
         int soChoNgoi=Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập kiểu xe  :  ");
         String kieuXe=scanner.nextLine();
        Oto oto = new Oto(bienKiemSoat,tenHang,namSanXuat,chuSoHuu,soChoNgoi,kieuXe);
        list.add(oto);
        funcWriteAndRead.writeFile("Oto.csv",list,true);
    }
    public List<Oto> findAll() {
        List<String[]> list = funcWriteAndRead.readFile("Oto.csv");
        List<Oto> otoList = new ArrayList<>();
        for (String[] strings : list) {
            Oto oto = new Oto(strings);
            otoList.add(oto);
        }
        return otoList;
    }

    public void  hienThiOto() {
        List<Oto> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).hienThiThongTin();
        }
    }
    public Oto findById(String bienKiemSoat) {
        List<Oto> list = findAll();
        for (Oto oto : list) {
            if (oto.getBienKiemSoat().equals(bienKiemSoat)) {
                return oto;
            }
        }
        return null;
    }
    public void delete(String bienKiemSoat) {
        List<Oto> list = findAll();
        for (Oto oto : list) {
            if (oto.getBienKiemSoat().equals(bienKiemSoat)) {
                list.remove(oto);
                funcWriteAndRead.writeFile("Oto.csv", list, false);
                return;
            }
        }
    }
}
