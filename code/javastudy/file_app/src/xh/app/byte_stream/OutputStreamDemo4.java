package xh.app.byte_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class OutputStreamDemo4 {
    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("file_app/src/test4.txt");

        os.write('1');
        os.write(98);
        os.write("\r\n".getBytes());

        byte[] buffer = "我爱中国".getBytes();
        os.write(buffer);

        os.close();

    }
}
