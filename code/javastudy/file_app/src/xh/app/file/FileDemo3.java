package xh.app.file;

import java.io.File;
import java.io.IOException;

public class FileDemo3 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("file_app/src/data.txt");
        // a.创建新文件，创建成功返回true ,反之 ,不需要这个，以后文件写出去的时候都会自动创建
        System.out.println(f1.createNewFile());
        // b.mkdir创建一级目录
        File f2 = new File("D:\\ing\\java\\test\\hhh");
        System.out.println(f2.mkdir());

        // c.mkdirs创建多级目录(重点)
        File f3 = new File("D:\\ing\\java\\test\\aaa\\bbb\\ccc");
        System.out.println(f3.mkdirs());
        // d.删除文件或者空文件夹
        System.out.println(f1.delete());


        // 只能删除空文件夹,不能删除非空文件夹.
        File f5 = new File("D:\\ing\\java\\test\\hhh");
        System.out.println(f5.delete());

    }
}
