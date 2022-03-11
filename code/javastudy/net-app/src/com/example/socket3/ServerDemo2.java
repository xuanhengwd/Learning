package com.example.socket3;

import com.example.socket2.ServerReaderThread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class ServerDemo2 {

    private static ExecutorService pool = new ThreadPoolExecutor(3,5,6, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2)
    , Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        try {

            System.out.println("=========服务端==========");

            ServerSocket serverSocket = new ServerSocket(6666);
            //必须调用accept方法：等待接收客户端的Socket连接请求，建立Socket通信管道
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"他来了！！");
                ServerReaderRunnable target = new ServerReaderRunnable(socket);
                pool.execute(target);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
