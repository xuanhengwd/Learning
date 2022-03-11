package xh.app.byte_stream;

import java.io.*;

public class CopyTest2 {
    //文件夹赋值
    public static void main(String[] args) {

        copy(new File("C:\\Users\\24564\\Desktop\\test\\Searching") , new File("C:\\Users\\24564\\Desktop\\test\\new"));
    }

    public static void copy(File src,File dest){
        if(src!=null&&src.exists()&&src.isDirectory()){

            //创建   D:\\new\\resourses
            File destOne = new File(dest,src.getName());//parent child
            destOne.mkdirs();

            File[] files = src.listFiles();

            //遍历
            for (File file : files) {
                if(file.isFile()){
                    copyFile(file,new File(destOne,file.getName()));
                }
                else {
                    copy(file,destOne);
                }
            }


        }
    }

    private static void copyFile(File srcFile, File destFile) {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(srcFile);
            os = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer))!=-1){
                os.write(buffer,0,len);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
