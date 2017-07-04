package org.grimlock.learn.test.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by songchunlei on 2017/7/4.
 */
public class BIOClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost",8080);
            OutputStream out = client.getOutputStream();
            out.write("客户端要连接到服务器".getBytes());
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
