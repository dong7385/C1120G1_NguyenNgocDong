package bai16_io_text_file.sp;

import on_tap.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncWriteAndRead {
    public static void writeProduct(Product product){
        File file = new File("src/bai16_io_text_file/sp/Product.csv");
        FileWriter fileWriter =null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(product.getId()+","+product.getName()+","+product.getPrice());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(" lỗi ghi file");
            e.printStackTrace();
        }
    }
    public static List<Product> readProduct(){
        List<Product> list = new ArrayList<>();
        File file = new File("src/bai16_io_text_file/sp/Product.csv");
        FileReader fileReader =null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line="";
            String[] arr =null;
            while ((line=bufferedReader.readLine())!=null){
                arr = line.split(",");
                Product product = new Product(arr[0],arr[1],Integer.parseInt(arr[2]));
                list.add(product);
            }

        } catch (FileNotFoundException e) {
            System.out.println("lôi đọc file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
