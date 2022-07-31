package xh.app.exception;

public class MyController {
    public static void main(String[] args) {
        Myservice myservice = new Myservice();
        try {
            myservice.test();
        } catch (Exception e) {
            System.out.println("e:"+e.getCause());
            System.out.println("e.getMessage:"+e.getMessage());
            //e.printStackTrace();
        }
    }
}
