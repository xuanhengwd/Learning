package xh.app.byte_stream;

import java.io.*;

public class CopyTest {
    public static void main(String[] args) {
            InputStream is = null;
            OutputStream os =null;

        try {
            is = new FileInputStream("C:\\Users\\24564\\Desktop\\test\\test.jpg");

            os = new FileOutputStream("C:\\Users\\24564\\Desktop\\test\\textCopy.jpg");

            byte[] buffer = new byte[1024];

            int len;
            while ((len=is.read(buffer))!=-1){
                os.write(buffer,0,len);
            }

            System.out.println("success!");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
