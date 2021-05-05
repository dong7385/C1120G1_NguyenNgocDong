package demo.Session_14_IO_text;

import java.io.File;
import java.io.IOException;

public class Create_File {
    private static final String PATH = "src/Session_14_IO_text/content";
    public static void main(String[] args) {

        //Tạo đối tượng File trỏ tới đường dẫn
        File dir = new File(PATH);
        //Tạo thư mục nếu đường dẫn không tồn tại
        dir.mkdir();
        //Tạo đối tượng File trỏ tới đường dẫn
        File file = new File(PATH,"test.txt");
        try {
            //Tạo file
            if (file.createNewFile()){
                System.out.println("File created..");
            }else {
                System.out.println("File already exists..");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Liệt kê nội dung thư mục
        if (dir.isDirectory()){
            String[] dirContent = dir.list();
            for (int i = 0; i < dirContent.length; i++ ){
                System.out.println(dirContent[i]);
            }
        }
    }
}
