package xh.app.charset;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CharsetDemo1 {
    public static void main(String[] args) {

        String s = "我爱中国";

        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        String res = new String(bytes);
        System.out.println(res);

    }
}
