package xh.app.file;

import java.io.File;
import java.util.Arrays;

public class FileDemo4 {
    public static void main(String[] args) {
        File f1 = new File("D:\\ing\\java\\test");
        String[] lists = f1.list();
        for (String list : lists) {
            System.out.println(list);
        }

        // 获取当前目录下所有的"一级文件对象"到一个文件对象数组中去返回（重点）
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

        File f2=new File("D:\\ing\\java\\test\\hhh");
        File[] files1 = f2.listFiles();
        System.out.println(files1);
        System.out.println(files1.length);
        System.out.println(Arrays.toString(files1));
    }
}
