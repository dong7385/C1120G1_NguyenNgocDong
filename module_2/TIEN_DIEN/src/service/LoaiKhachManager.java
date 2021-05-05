package service;

import commons.FuncWriteAndRead;
import model.LoaiKhach;
import model.NnKhachHang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoaiKhachManager {
    static FuncWriteAndRead<LoaiKhach> functionReadAndWrite = new FuncWriteAndRead<>();
    public List<LoaiKhach> findAll(){
        List<String[]> list = functionReadAndWrite.readFile("LoaiKhach.csv");
        List<LoaiKhach>loaiKhachList=new ArrayList<>();
        for (String[]strings :list) {
            LoaiKhach loaiKhach=new LoaiKhach(strings);
            loaiKhachList.add(loaiKhach);
        }
        return loaiKhachList;
    }
}
