package service;

import commons.FuncWriteAndRead;
import model.Oto;
import model.XeMay;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyXeMay {
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<XeMay> funcWriteAndRead = new FuncWriteAndRead();

    public void themXeMay() {
        List<XeMay> list = new ArrayList<>();
        System.out.print("Nhập biển kiểm soát:");
        String bienKiemSoat = scanner.nextLine();
        System.out.print("Nhập tên hàng:");
        String tenHang = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        String namSanXuat = scanner.nextLine();
        System.out.print("Nhập chủ sở hữu: ");
        String chuSoHuu = scanner.nextLine();
        System.out.println("Nhập công xuất ");
        int congSuat = Integer.parseInt(scanner.nextLine());
        XeMay xeMay = new XeMay(bienKiemSoat, tenHang, namSanXuat, chuSoHuu, congSuat);
        list.add(xeMay);
        funcWriteAndRead.writeFile("XeMay.csv", list, true);
    }
    public List<XeMay> findAll() {
        List<String[]> list = funcWriteAndRead.readFile("XeMay.csv");
        List<XeMay> xeMayList = new ArrayList<>();
        for (String[] strings : list) {
            XeMay xeMay = new XeMay(strings);
            xeMayList.add(xeMay);
        }
        return xeMayList;
    }

    public void  hienThiXeMay() {
        List<XeMay> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).hienThiThongTin();
        }
    }
    public XeMay findById(String bienKiemSoat) {
        List<XeMay> list = findAll();
        for (XeMay xeMay : list) {
            if (xeMay.getBienKiemSoat().equals(bienKiemSoat)) {
                return xeMay;
            }
        }
        return null;
    }
    public void delete(String bienKiemSoat) {
        List<XeMay> list = findAll();
        for (XeMay xeMay : list) {
            if (xeMay.getBienKiemSoat().equals(bienKiemSoat)) {
                list.remove(xeMay);
                funcWriteAndRead.writeFile("XeMay.csv", list, false);
                return;
            }
        }
    }
}

