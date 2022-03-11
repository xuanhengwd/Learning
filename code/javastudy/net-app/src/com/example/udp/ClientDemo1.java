package com.example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//发送端
public class ClientDemo1 {
    public static void main(String[] args) throws Exception {

        System.out.println("=======send========");
        DatagramSocket socket = new DatagramSocket();

        byte[] buf = "哈哈哈哈".getBytes();

        DatagramPacket packet = new DatagramPacket(buf,buf.length, InetAddress.getLocalHost(),8888);

        socket.send(packet);

        socket.close();
    }
}
