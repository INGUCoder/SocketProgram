package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * 接收文件
 */
public class TcpServerFileGetDemo {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        while (true) {
            try {
                //创建服务端
                serverSocket = new ServerSocket(9000);
                //等待客户端响应
                socket = serverSocket.accept();
                //读取客户端流信息
                inputStream = socket.getInputStream();
                //输出文件
                fileOutputStream = new FileOutputStream(new File("2.jpg"));
                //创建缓存区
                byte[] bytes = new byte[1024];
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, len);
                }
                //通知客户端接收文件完毕
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("接收文件完毕！".getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
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
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }


    }


}
