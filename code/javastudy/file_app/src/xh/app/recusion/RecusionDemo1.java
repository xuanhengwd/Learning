package xh.app.recusion;

import java.io.File;

public class RecusionDemo1 {
    public static void main(String[] args) {
        searchFile(new File("D:/"),"test.jpg");
    }

    public static void searchFile(File file,String fileName){
        if(file!=null&&file.isDirectory()){
            //获取目录下的文件
            File[] files = file.listFiles();
            //不为空则遍历
            if(files!=null&&files.length>0){
                for (File f : files) {
                    if(f.isFile()){
                        //是文件 判断
                        if(f.getName().contains(fileName)){
                            System.out.println("找到了:"+f.getAbsolutePath());

                        }
                    }
                    else {
                        //是文件夹 递归
                        searchFile(f,fileName);
                    }
                }

            }


        }else {
            System.out.println("不是文件夹");
        }


    }
}
