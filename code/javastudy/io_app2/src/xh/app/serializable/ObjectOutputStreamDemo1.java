package xh.app.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        Student st = new Student("赵三",12,99.8);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io_app2/src/obj.txt"));

        oos.writeObject(st);

        oos.close();
        System.out.println("success");





    }
}
