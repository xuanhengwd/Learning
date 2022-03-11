package xh.app.byte_stream;

import com.sun.jdi.event.StepEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInputStreamDemo2 {
    public static void main(String[] args) throws Exception {
        InputStream is =  new FileInputStream("file_app/src/test2.txt");
//        byte[] buffer = new byte[3];
//        int len = is.read(buffer);
//        System.out.println(len);
//        String s = new String(buffer);
//        System.out.println(s);



        //循环
        byte[] buffer = new byte[3];
        int len;//记录每次得到的字节数
        while((len=is.read(buffer))!=-1){
            String s = new String(buffer, 0, len);
            System.out.print(s);
        }

        is.close();
    }
}
