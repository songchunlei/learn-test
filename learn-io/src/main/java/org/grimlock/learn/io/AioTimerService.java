package org.grimlock.learn.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by songchunlei on 2017/7/12.
 */
public class AioTimerService {

    private int port;
    private AsynchronousServerSocketChannel serverSocketChannel;
    private CountDownLatch latch;
    static CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();

    public static void main(String[] args) throws IOException {
        AioTimerService service = new AioTimerService();
        service.listen(8080);
    }

    private void listen(int port) throws IOException {
        this.port = port;
        serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.accept(this,new AcceptHandler());
        System.out.println("服务已启动:"+port);
        latch = new CountDownLatch(1);
        new Thread(){
            public void run(){
                try{
                    latch.await();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel,AioTimerService> {

        public void completed(AsynchronousSocketChannel socketChannel, AioTimerService attachment) {
            try {
                socketChannel.setOption(StandardSocketOptions.TCP_NODELAY,true);
                socketChannel.setOption(StandardSocketOptions.SO_SNDBUF,1024);
                socketChannel.setOption(StandardSocketOptions.SO_RCVBUF,1024);
                if(socketChannel.isOpen()){
                    final ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer,socketChannel,new ReadHandler(buffer));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                //递归调用监听
                attachment.serverSocketChannel.accept(attachment,this);
            }

        }

        public void failed(Throwable exc, AioTimerService attachment) {
            attachment.serverSocketChannel.accept(attachment,this);
        }
    }

    private class ReadHandler implements CompletionHandler<Integer,AsynchronousSocketChannel>{

        private ByteBuffer buffer;

        public ReadHandler(ByteBuffer buffer){
            this.buffer = buffer;
        }

        public void completed(Integer result, AsynchronousSocketChannel attachment) {
            if(result<0)
            {
                doClose(attachment);
            }
            else if(result == 0){
                //空字节忽略
            }else if(result>0){
                buffer.flip();
                try {
                    CharBuffer charBuffer = decoder.decode(buffer);
                    System.out.println(charBuffer.toString());
                    buffer.clear();
                    String res = "OK"+ SimpleDateFormat.getDateTimeInstance().format(new Date());
                    buffer = ByteBuffer.wrap(res.getBytes());
                    attachment.write(buffer,attachment,new WriteHand(buffer));
                } catch (CharacterCodingException e) {
                    e.printStackTrace();
                }

            }
        }

        public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
            doClose(attachment);
        }
    }

    private class WriteHand implements CompletionHandler<Integer,AsynchronousSocketChannel>{

        private ByteBuffer buffer;

        public WriteHand(ByteBuffer buffer){
            this.buffer = buffer;
        }


        public void completed(Integer result, AsynchronousSocketChannel attachment) {
            buffer.clear();
            doClose(attachment);
        }

        public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
            doClose(attachment);
        }
    }

    private void doClose(AsynchronousSocketChannel attachment) {
        try {
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
