package com.xiaogch.maven.netty.messagepack;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.*;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/14 15:11 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class MessagePackClient {
    Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String...argvs) {
        MessagePackClient messagePackClient = new MessagePackClient();
        messagePackClient.connect("127.0.0.1" , 8080);
    }

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
                            //LengthFieldBasedFrameDecoder用于处理半包消息
                            //这样后面的MsgpackDecoder接收的永远是整包消息
                            socketChannel.pipeline().addLast("frameDecoder",new LengthFieldBasedFrameDecoder(65535,0,2,0,2));
                            socketChannel.pipeline().addLast("msgpack decoder",new MessagePackDecoder());
                            //在ByteBuf之前增加2个字节的消息长度字段
                            socketChannel.pipeline().addLast("frameEncoder",new LengthFieldPrepender(2));
                            socketChannel.pipeline().addLast("msgpack encoder",new MessagePackEncoder());
                            socketChannel.pipeline().addLast(new MessagePackClientHandler());
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

    class MessagePackClientHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(1);
            userInfo.setName("name " + 1);
            userInfo.setAddress("address " + 1);
            ctx.writeAndFlush(userInfo);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            logger.info("receive message is {}" , msg);
            ctx.writeAndFlush(msg);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            logger.error("exceptionCaught " , cause);
            ctx.close();
        }
    }

}
