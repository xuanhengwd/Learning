package xh.app.file;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileDemo2 {
    public static void main(String[] args) {
        File f1 = new File("D:\\ing\\java\\test\\test.jpg");
        System.out.println(f1.exists());
        //获取绝对路径
        System.out.println(f1.getAbsolutePath());
        //获取文件定义时使用的路径
        System.out.println(f1.getPath());
        // c.获取文件的名称：带后缀。
        System.out.println(f1.getName());
        // d.获取文件的大小：字节个数。
        System.out.println(f1.length());
        // e.获取文件的最后修改时间
        long l = f1.lastModified();
        System.out.println(l);
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(l));

        // f、判断文件是文件还是文件夹
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
    }
}
