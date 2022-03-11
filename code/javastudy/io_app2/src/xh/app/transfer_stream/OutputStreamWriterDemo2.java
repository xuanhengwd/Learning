package xh.app.transfer_stream;

import java.io.*;

public class OutputStreamWriterDemo2 {
    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("io_app2/src/out03.txt");

        // 2、把原始的字节输出流转换成字符输出流
        // Writer osw = new OutputStreamWriter(os); // 以默认的UTF-8写字符出去 跟直接写FileWriter一样
        Writer osw = new OutputStreamWriter(os , "GBK"); // 指定GBK的方式写字符出去

        // 3、把低级的字符输出流包装成高级的缓冲字符输出流。
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("我爱中国1~~");
        bw.write("我爱中国2~~");
        bw.write("我爱中国3~~");

        bw.close();
    }
}
