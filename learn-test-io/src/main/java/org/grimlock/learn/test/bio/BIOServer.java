package org.grimlock.learn.test.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by songchunlei on 2017/7/4.
 */
public class BIOServer {
    ServerSocket server;
    public BIOServer(int port){
        try {
            server = new ServerSocket(port);
            System.out.println("BIO服务已启动，等待接入");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            Socket client = server.accept();
            InputStream is = client.getInputStream();
            byte[] buff = new byte[1024];
            int len = is.read( buff);
            if (len>0){
                String msg = new String(buff,0,len);
                System.out.println("BIO服务端已经接收到客户端数据，数据内容为"+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new BIOServer(8080).start();
    }
}
