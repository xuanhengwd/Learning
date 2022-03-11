package xh.app.transfer_stream;

import java.io.*;

public class InputStreamReaderDemo1 {
    public static void main(String[] args) throws Exception {

        InputStream is = new FileInputStream("C:\\Users\\24564\\Desktop\\test\\data.txt");
        // 2、把原始字节流转换成字符输入流
//         Reader isr = new InputStreamReader(is); // 默认以UTF-8的方式转换成字符流。 还是会乱码的  跟直接使用FileReader是一样的
        Reader isr = new InputStreamReader(is , "GBK"); // 以指定的GBK编码转换成字符输入流  完美的解决了乱码问题

        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

    }
}
