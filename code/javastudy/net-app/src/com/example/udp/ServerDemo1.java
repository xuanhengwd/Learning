package com.example.udp;

import java.net.*;
import java.nio.charset.StandardCharsets;

//接受端
public class ServerDemo1 {
    public static void main(String[] args) throws Exception {

        System.out.println("=======receive==========");
        DatagramSocket socket = new DatagramSocket(8888);

        byte[] buf = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        socket.receive(packet);

        int len = packet.getLength();
        System.out.println(new String(buf,0,len));


        SocketAddress socketAddress = packet.getSocketAddress();
        String ip = socketAddress.toString();
        System.out.println("对方地址"+ip);

        int port = packet.getPort();
        System.out.println("对方端口"+port);

        socket.close();

    }
}
