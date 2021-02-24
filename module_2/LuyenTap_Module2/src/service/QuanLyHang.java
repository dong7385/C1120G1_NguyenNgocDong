package service;

import commons.FuncWriteAndRead;
import model.HangSanXuat;
import java.util.ArrayList;
import java.util.List;


public class QuanLyHang {
    static FuncWriteAndRead<HangSanXuat> funcWriteAndRead = new FuncWriteAndRead();
    public List<HangSanXuat> findAll() {
        List<String[]> list = funcWriteAndRead.readFile("HangSanXuat.csv");
        List<HangSanXuat> hangSanXuatList = new ArrayList<>();
        for (String[] strings : list) {
            HangSanXuat hangSanXuat = new HangSanXuat(strings);
            hangSanXuatList.add(hangSanXuat);
        }
        return hangSanXuatList;
    }
}
