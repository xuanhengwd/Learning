package xh.app.print_stream;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintStreamDemo1 {
    public static void main(String[] args) {
        try(
                PrintWriter pw = new PrintWriter("io_app2/src/test2.txt");
                ) {
            pw.print("我打啥就会输出啥！！！"+true+"a"+99);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
