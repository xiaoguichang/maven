package com.xiaogch.maven.netty.messagepack;

import com.xiaogch.maven.netty.timer.TimerServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/14 17:45 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class MessagepackServer {

    Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String...argvs) {
        MessagepackServer messagepackServer = new MessagepackServer();
        messagepackServer.bind(8080);
    }

    public void bind(int port){
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(boss , worker)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG , 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>(){
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast("frameDecoder" , new LengthFieldBasedFrameDecoder(65535,0,2,0,2))
                                    .addLast(new StringDecoder())
                                    .addLast(new MessagepackServerHandler());
                        }
                    });
            ChannelFuture channelFuture = b.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.info("bind to port " + port + " exception" , e);
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    class MessagepackServerHandler extends ChannelInboundHandlerAdapter {

        public MessagepackServerHandler() {
            super();
        }

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            super.channelRegistered(ctx);
        }


        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            super.channelActive(ctx);
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            super.channelInactive(ctx);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//            String message = (String) msg;
//            logger.info("receive message is {}" , message);
//            String str;
//            if ("get now time".equalsIgnoreCase(message)) {
//                str = "now is" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            } else {
//                str = "unknown message";
//            }
//            logger.info("response message is {}" , str + System.getProperty("line.separator"));
//            byte[] bytes = (str + System.getProperty("line.separator")).getBytes();
//            ByteBuf byteBuf = Unpooled.buffer(bytes.length);
//            byteBuf.writeBytes(bytes);
//            ctx.writeAndFlush(byteBuf);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            super.channelReadComplete(ctx);
        }

        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            super.userEventTriggered(ctx, evt);
        }

        @Override
        public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
            super.channelWritabilityChanged(ctx);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            logger.error("exceptionCaught " , cause);
            ctx.close();
        }
    }

}
