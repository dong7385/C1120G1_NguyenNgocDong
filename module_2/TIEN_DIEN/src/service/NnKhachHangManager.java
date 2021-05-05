package service;

import commons.FuncWriteAndRead;
import model.NnKhachHang;
import model.VnKhachHang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NnKhachHangManager {
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<NnKhachHang> functionReadAndWrite = new FuncWriteAndRead<>();

    public void themNnKhachHang() {
        List<NnKhachHang> list = new ArrayList<>();

        System.out.println("Vui long chon ma khach hang");
        String maKhachHang = scanner.nextLine();
        System.out.println("vui ling chon ho ten khach hang");
        String hoten = scanner.nextLine();
        System.out.println("vui ling chon quoc tich");
        String quocTich = scanner.nextLine();
        NnKhachHang nnKhachHang = new NnKhachHang(maKhachHang, hoten, quocTich);
        list.add(nnKhachHang);
        functionReadAndWrite.writeFile("KhachHang.csv", list, true);
    }

    public List<NnKhachHang> findAll() {
        List<String[]> list = functionReadAndWrite.readFile("KhachHang.csv");
        List<NnKhachHang> nnKhachHangList = new ArrayList<>();
        for (String[] strings : list) {
            NnKhachHang nnKhachHang = new NnKhachHang(strings);
            nnKhachHangList.add(nnKhachHang);
        }
        return nnKhachHangList;
    }
}
