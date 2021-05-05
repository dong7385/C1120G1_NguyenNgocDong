package io_text_file.bai_tap.CopyFile;
import java.io.*;


public class CopyFileText {
    static final String  PATH1="src/io_text_file/bai_tap/CopyFile/a.csv";
    static final String  PATH2="src/io_text_file/bai_tap/CopyFile/c.csv";
        public static void main(String[] args) {
            File file1 = new File(PATH1);
            File file2 = new File(PATH2);
            try {
                FileReader fileReader = new FileReader(file1);
                BufferedReader bufferedReader =new BufferedReader(fileReader);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
                String line;
                while ((line =bufferedReader.readLine()) !=null){
                    System.out.println(line);
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

