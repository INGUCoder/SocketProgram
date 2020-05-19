package net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


/**
 * 客户端
 */
public class TcpClientDemo1 {

    public static void main(String[] args) {
        OutputStream outputStream = null;
        Socket socket = null;
        try {
            //得到服务器的地址
            InetAddress address = InetAddress.getByName("127.0.0.1");
            //创建端口号
            int port = 9999;
            //创建一个socket连接
            socket = new Socket(address, port);
            //发送消息IO流
            outputStream = socket.getOutputStream();
            outputStream.write("你好啊！".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
