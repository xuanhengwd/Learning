package com.example.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo1 {
    public static void main(String[] args) throws Exception {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());

        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());


        //是否能通
        System.out.println(ip2.isReachable(5000));


    }
}
