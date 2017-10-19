package com.xiaogch.maven.netty.messagepack;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/14 17:45 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class MessagePackServer {

    Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String...argvs) {
        MessagePackServer messagepackServer = new MessagePackServer();
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
                            //LengthFieldBasedFrameDecoder用于处理半包消息
                            //这样后面的MsgpackDecoder接收的永远是整包消息
                            socketChannel.pipeline().addLast("frameDecoder",new LengthFieldBasedFrameDecoder(65535,0,2,0,2));
                            socketChannel.pipeline().addLast("msgpack decoder",new MessagePackDecoder());
                            //在ByteBuf之前增加2个字节的消息长度字段
                            socketChannel.pipeline().addLast("frameEncoder",new LengthFieldPrepender(2));
                            socketChannel.pipeline().addLast("msgpack encoder",new MessagePackEncoder());
                            socketChannel.pipeline().addLast(new MessagepackServerHandler());
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
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            logger.info("receive message is {}" , msg);
            ctx.write(msg);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            logger.error("exceptionCaught " , cause);
            ctx.close();
        }
    }

}
