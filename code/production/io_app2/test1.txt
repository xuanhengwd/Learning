package xh.app.byte_buffer;

import java.io.*;

public class ByteBufferDemo1 {
    public static void main(String[] args) {

        try
                (InputStream is = new FileInputStream("C:\\Users\\24564\\Desktop\\test\\test.jpg");
                 //把原始的字节输入流包装成高级的缓冲字节输入流
                 InputStream bis = new BufferedInputStream(is);

                 OutputStream os = new FileOutputStream("C:\\Users\\24564\\Desktop\\test\\testCopy.jpg");
                 //包装
                 OutputStream bos = new BufferedOutputStream(os);
                ) {


            byte[] buffer = new byte[1024];
            int len;

            while ((len=bis.read(buffer))!=-1)
            {
                bos.write(buffer,0,len);
            }

            System.out.println("success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
