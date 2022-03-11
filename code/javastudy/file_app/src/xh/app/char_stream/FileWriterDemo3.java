package xh.app.char_stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo3 {
    public static void main(String[] args) throws Exception {
        Writer wr = new FileWriter("file_app/src/test5.txt");

        wr.write('a');
        wr.write("中国");
        wr.write("\r\n");

        char[] c = "我是中国人aaaa".toCharArray();
        wr.write(c);

        wr.write("\r\n");
        wr.write("我是中国人hhhhh",0,5);

        wr.write("\r\n");
        wr.write(c,3,5);

        wr.close();
    }
}
