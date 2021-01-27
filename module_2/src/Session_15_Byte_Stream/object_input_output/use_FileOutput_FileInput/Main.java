package Session_15_Byte_Stream.use_FileOutput_FileInput;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

public class Main {
    private static final String PATH_FILE = "src/Session_15_Byte_Stream/use_FileOutput_FileInput/data.dat";

    public static void main(String[] args) {
        InputStream fis = null;
        OutputStream fot = null;
        try {
            File file = new File(PATH_FILE);
            fis = new FileInputStream(file);
            fot = new FileOutputStream(file);
            fot.write('a');
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            fis.close();
            fot.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
