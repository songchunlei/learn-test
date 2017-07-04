package org.grimlock.learn.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by songchunlei on 2017/7/4.
 */
public class ServerSocket {
    ServerSocketChannel serverSocketChannel;
    Selector selector;
    public void start(){
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost", 8080));
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//注册接收事件
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void bindEvent(){
        while (true)
        {
            int i = 0;
            try {
                i = selector.select();
                if(i==0)
                {
                    continue;
                }
                //封装channel通道
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        SocketChannel client = serverSocketChannel.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);

                    } else if (key.isReadable())
                    {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer bb = ByteBuffer.allocate(1024);
                        int len = client.read(bb);
                        if(len>0)
                        {
                            System.out.println("服务端已接收到了客户端的数据，数据内容是:"+new String(bb.array(),0,len));
                            client.register(selector,SelectionKey.OP_WRITE);
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
