package xh.app.byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamDemo3 {
    public static void main(String[] args) throws Exception {
        File f = new File("file_app/src/test3.txt");
        InputStream is = new FileInputStream(f);

        byte[] buffer = new byte[(int) f.length()];

        System.out.println(f.length());
        int read = is.read(buffer);
        System.out.println(read);

        System.out.println(new String(buffer));

        is.close();



//
//        byte[] buffer = is.readAllBytes();
//        System.out.println(new String(buffer));

    }
}

