package xh.app.file;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        //File f1 = new File("File f1 = new File(\"file_app\\\\src\\\\text.txt\");");
        File f1 = new File("file_app\\src\\text.txt");
        long length = f1.length();
        System.out.println(length);

        File f2 = new File("file_app\\src");
        System.out.println(f2.exists());

    }
}
