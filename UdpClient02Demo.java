package net;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 还是要等待客户端的连接
 */
public class UdpClient02Demo {
    public static void main(String[] args) {

        DatagramSocket datagramSocket =null;
        try {
            //开放端口
            datagramSocket = new DatagramSocket(9001);
            //接收数据包
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);

            //等待接收 阻塞
           datagramSocket.receive(datagramPacket);
           System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            datagramSocket.close();
        }


    }


}
