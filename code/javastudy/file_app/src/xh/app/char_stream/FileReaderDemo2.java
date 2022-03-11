package xh.app.char_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo2 {
    public static void main(String[] args) throws Exception {
        Reader re = new FileReader("file_app/src/test4.txt");

        char[] buffer = new char[1024];
        int len;
        while ((len=re.read(buffer))!=-1){
            String res = new String(buffer,0,len);
            System.out.print(res);
        }
    }
}
