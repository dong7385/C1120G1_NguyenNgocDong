package io_text_file.thuc_hanh;

import java.io.*;
import java.util.Scanner;

public class TextIO {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
//        File file =new File("test.txt");
//////        if(file.isFile()){
//////
//////            System.out.println("file: "+file.getAbsolutePath());
//////        }else {
//////            System.out.println("Not found");
//////            file.createNewFile();
//////        }
//        Scanner scanner= new Scanner(System.in);
//        System.out.println("Nhap N: ");
//        int n=scanner.nextInt();
//        cách 2:
//        DataInputStream dataInputStream=new DataInputStream(System.in);
//        System.out.println("Nhap n:  ");
//        int n=Integer.parseInt(dataInputStream.readLine());
        try {
            fileInputStream = new FileInputStream("test.txt");
            fileOutputStream = new FileOutputStream("test_cp");
            int check;
            while ((check = fileInputStream.read()) != -1) {
                System.out.print((char) check);
                fileOutputStream.write(check);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
