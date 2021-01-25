package io_text_file.thuc_hanh;

import java.io.*;
import java.util.Scanner;

public class FileText {
    public void readFileText(String filePath)  {
       try {
           File file=new File(filePath);
           if (!file.exists()){
               throw new FileNotFoundException();
           }
           BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
           String line=" ";
           int sum=0;
           while ((line=bufferedReader.readLine())!=null){
               System.out.println(line);
               sum+=Integer.parseInt(line);
           }
           bufferedReader.close();
           System.out.println("Sun:   = " + sum);

       }catch (IOException e) {
           System.err.println("Fie không tồn tại or nội dung có lỗi!");
       }
    }

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file");
        Scanner scanner=new Scanner(System.in);
        String path=scanner.nextLine();
        FileText fileText=new FileText();
        fileText.readFileText(path);
    }
}
