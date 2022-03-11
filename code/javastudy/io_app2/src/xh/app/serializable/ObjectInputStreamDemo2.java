package xh.app.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo2 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io_app2/src/obj.txt"));

        Student s = (Student) ois.readObject();
        System.out.println(s);
    }
}
