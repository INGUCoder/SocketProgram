package net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClient01Demo {
    public static void main(String[] args) {

        DatagramSocket datagramSocket = null;

        try {
            //建立一个socket
            datagramSocket = new DatagramSocket();
            //建立包
            String msg = "你好!";
            InetAddress inetAddress = InetAddress.getByName("localhost");
            int port = 9001;
            //要发送给谁 数据长度
            DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, inetAddress, port);
            //发送包
            datagramSocket.send(datagramPacket);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();

        }


    }


}
