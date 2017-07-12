package org.grimlock.learn.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by songchunlei on 2017/7/12.
 */
public class NioTimerService implements Runnable {
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private volatile boolean step = false;

    public NioTimerService(int port) throws IOException {
        this.serverSocketChannel = ServerSocketChannel.open();
        this.selector = Selector.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",port));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("the time Service is start in port:"+port);
        //工作线程
    }

    public static void main(String[] args) throws IOException {
        int port = 8800;
        if (args!=null && args.length>1)
        {
            port = Integer.parseInt(args[0]);
        }
        new Thread(new NioTimerService(port),"NIO-Multip-selector").start();
    }

    //轮询
    public void run() {

    }
}
