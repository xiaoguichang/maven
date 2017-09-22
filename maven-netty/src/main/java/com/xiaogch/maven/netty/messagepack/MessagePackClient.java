package com.xiaogch.maven.netty.timer;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/14 15:11 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class TimerClient {
    Logger logger = LoggerFactory.getLogger(getClass());

    public void connect(String host , int port) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        try {
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY , true)
                    .option(ChannelOption.SO_KEEPALIVE , true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //FixedLengthFrameDecoder //定长解析器
                            FixedLengthFrameDecoder b = new FixedLengthFrameDecoder(1024);
                            //DelimiterBasedFrameDecoder //分隔符解析器
                            ByteBuf bf = Unpooled.copiedBuffer("$_".getBytes());
                            DelimiterBasedFrameDecoder a = new DelimiterBasedFrameDecoder(1024 , bf);
                            socketChannel.pipeline()
                                    //.addLast(a)
                                    //.addLast(b)
                                    //LineBasedFrameDecoder  //\n 或 \r\n 作为分隔符的解析器， 特殊的DelimiterBasedFrameDecoder
                                    .addLast(new LineBasedFrameDecoder(1024))
                                    .addLast(new StringDecoder())
                                    .addLast(new TimerClientHandler());
                        }
                    });
            ChannelFuture channelFuture = b.connect(host , port).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("connect exception" , e);
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String...argvs) {
        TimerClient timerClient = new TimerClient();
        timerClient.connect("127.0.0.1" , 8080);
    }

    class TimerClientHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            String line = "get now time" + System.getProperty("line.separator");
            ByteBuf byteBuf = Unpooled.buffer(line.getBytes().length);
            byteBuf.writeBytes(line.getBytes());
            ctx.writeAndFlush(byteBuf);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            String message = (String) msg;
            logger.info("receive message is {}" , message);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            logger.error("exceptionCaught " , cause);
            ctx.close();
        }
    }

}
