package demo.Session_14_IO_text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read_Content_File {
    static final String PATH = "src/Session_14_IO_text/content/test.txt";

    public static void main(String[] args) {
        FileReader fileReader;
        BufferedReader bufferReader;
        try {
            fileReader = new FileReader(PATH);
            bufferReader = new BufferedReader(fileReader);
            StringBuffer result = new StringBuffer();
            String line;
            while ( (line = bufferReader.readLine()) != null){
                result.append(line);
            }
            System.out.println(result);
            bufferReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
