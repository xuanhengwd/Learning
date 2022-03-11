package xh.app.char_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo1 {
    public static void main(String[] args) throws Exception {
        Reader re = new FileReader("file_app/src/test4.txt");
//
//        int r = re.read();
//        System.out.println(r);

        int code;
        while ((code=re.read())!=-1){
            System.out.print((char)code);
        }
    }
}
