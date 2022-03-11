package com.example.socket;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientDemo1 {
    public static void main(String[] args) {
        try {

            System.out.println("=========客户端==========");
            // 1、创建Socket通信管道请求有服务端的连接
            Socket socket = new Socket("127.0.0.1",7777);

            OutputStream os = socket.getOutputStream();

            PrintStream ps = new PrintStream(os);

            ps.println("我是哈哈哈哈");
            ps.flush();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
