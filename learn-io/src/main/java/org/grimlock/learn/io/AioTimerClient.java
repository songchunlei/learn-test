package org.grimlock.learn.io;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * Created by songchunlei on 2017/7/12.
 */
public class AioTimerClient {
    private AsynchronousSocketChannel socketChannel;
    private CountDownLatch latch;

    public AioTimerClient() throws IOException{
        this.socketChannel = AsynchronousSocketChannel.open();
        this.latch = new CountDownLatch(1);
    }

    public void send(){
        socketChannel.connect(new InetSocketAddress("127.0.0.1",8080),socketChannel,new ConnectHandler());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class ConnectHandler implements CompletionHandler<Void,AsynchronousSocketChannel>{

        public void completed(Void result, AsynchronousSocketChannel attachment) {
            ByteBuffer buffer = ByteBuffer.wrap("query Current Time".getBytes());
            attachment.write(buffer,attachment,new WriteHandler(buffer));
        }

        public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
            doClose();
        }
    }

    private void doClose() {
        try {
            socketChannel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        AioTimerClient client = new AioTimerClient();
        client.send();

    }

    private class WriteHandler implements CompletionHandler<Integer,AsynchronousSocketChannel>{

        private ByteBuffer buffer;

        public WriteHandler(ByteBuffer buffer) {
            this.buffer = buffer;
        }

        public void completed(Integer result, AsynchronousSocketChannel attachment) {

        }

        public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
            doClose();
        }
    }
}
