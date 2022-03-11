package xh.app.byte_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("file_app/src/test1.txt");

//        int t1 = is.read();
//        System.out.print(t1);

        int b;
        while((b=is.read())!=-1)
        {
            System.out.print((char)b);
        }

        is.close();
    }
}
