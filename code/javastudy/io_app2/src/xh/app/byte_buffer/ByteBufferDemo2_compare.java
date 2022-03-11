package xh.app.byte_buffer;

import java.io.*;

public class ByteBufferDemo2_compare {

    private static final String src = "C:\\Users\\24564\\Desktop\\test\\testvideo.mp4";
    private static final String dest = "C:\\Users\\24564\\Desktop\\test\\new\\";


    public static void main(String[] args) {
        //copy1();//超级慢
        copy2();//较慢 但还不错
        copy3();//很慢不建议
        copy4();//起飞~~~

    }

    /**
     * 单个字节复制文件
     */
    public static void copy1() {
        long start = System.currentTimeMillis();
        try (
                InputStream is = new FileInputStream(src);
                OutputStream os = new FileOutputStream(dest + "c1.mp4");
             ) {

            int b;
            while ((b = is.read()) != -1) {
                os.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("低级字节流单字节复制耗时："+(end-start)/1000.0+"s");

    }

    /**
     * 低级字节流按字节数组形式
     */
    public static void copy2() {
        long start = System.currentTimeMillis();
        try (
                InputStream is = new FileInputStream(src);
                OutputStream os = new FileOutputStream(dest + "c2.mp4");
        ) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer)) != -1) {
                os.write(buffer,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("低级字节流字节数组复制耗时："+(end-start)/1000.0+"s");

    }

    /**
     *使用缓冲的字节流按照一个一个字节的形式复制文件
     */
    public static void copy3() {
        long start = System.currentTimeMillis();
        try (
                InputStream is = new FileInputStream(src);
                InputStream bis = new BufferedInputStream(is);
                OutputStream os = new FileOutputStream(dest + "c3.mp4");
                OutputStream bos = new BufferedOutputStream(os);

        ) {


            int b;
            while ((b=bis.read()) != -1) {
                bos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("缓冲字节流单字节复制耗时："+(end-start)/1000.0+"s");

    }

    /**
     * 缓冲字节流 字节数组复制
     */

    public static void copy4() {
        long start = System.currentTimeMillis();
        try (
                InputStream is = new FileInputStream(src);
                InputStream bis = new BufferedInputStream(is);
                OutputStream os = new FileOutputStream(dest + "c4.mp4");
                OutputStream bos = new BufferedOutputStream(os);

        ) {


            byte[] buffer = new byte[1024];
            int len;
            while ((len=bis.read(buffer)) != -1) {
                bos.write(buffer,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("缓冲字节流字节数组复制耗时："+(end-start)/1000.0+"s");

    }
}
