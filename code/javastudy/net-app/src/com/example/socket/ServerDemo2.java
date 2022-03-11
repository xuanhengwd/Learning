package com.example.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    public static void main(String[] args) {

        try {

            System.out.println("=========服务端==========");

            ServerSocket serverSocket = new ServerSocket(7777);
            //必须调用accept方法：等待接收客户端的Socket连接请求，建立Socket通信管道
            Socket socket = serverSocket.accept();

            InputStream is = socket.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String msg;
            while((msg=br.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+"说了："+msg);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
