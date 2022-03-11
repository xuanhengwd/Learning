package xh.app.char_buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CharBufferDemo1 {
    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new FileReader("io_app2/src/test1.txt"));
            String line;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
