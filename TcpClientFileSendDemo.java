package net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 用tcp原理实现文件发送
 * 客户端
 */
public class TcpClientFileSendDemo {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        //创建管道输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = null;

        //创建连接地址
        try {
            //创建连接地址
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            //创建端口连接号
            int port = 9000;
            //创建socket连接
            socket = new Socket(inetAddress, port);
            //创建输出流
            outputStream = socket.getOutputStream();
            //读取文件
            fileInputStream = new FileInputStream(new File("C:\\Users\\mz\\Desktop\\Test\\src\\1.jpg"));
            //写出文件 创建缓冲区
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }

            //通知服务器 已经传输完成
            socket.shutdownOutput();
            //确定服务器接收文件完毕才断开连接
            inputStream = socket.getInputStream();

            byte[] bytes2 = new byte[1024];
            int len2;
            while ((len2 = inputStream.read(bytes2)) != -1) {
                byteArrayOutputStream.write(bytes2, 0, len2);
            }
            System.out.println(byteArrayOutputStream.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
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
