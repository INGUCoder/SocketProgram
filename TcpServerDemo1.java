package net;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class TcpServerDemo1 {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        //创建管道流 输出客户端发过来的数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ServerSocket serverSocket=null;
        while (true){
            try {
                //创建客户端和端口号
                serverSocket = new ServerSocket(9999);
                //等待客户端连接
                socket = serverSocket.accept();
                //读取客户端信息
                inputStream = socket.getInputStream();

                byte[] buffer = new byte[1024];
                int len=0;
                while ((len=inputStream.read(buffer))!=-1){
                    byteArrayOutputStream.write(buffer,0,len);
                }
                System.out.println(byteArrayOutputStream.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(byteArrayOutputStream!=null){
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                if(inputStream!=null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(socket!=null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(serverSocket!=null){
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
