package com.xiaogch.maven.netty.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/13 14:09 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    Logger logger = LoggerFactory.getLogger(getClass());

    public DiscardServerHandler() {
        super();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelRegistered begin ....");
        super.channelRegistered(ctx);
        logger.info("channelRegistered end ....");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelActive begin ....");
        super.channelActive(ctx);
        logger.info("channelActive end ....");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelInactive begin ....");
        super.channelInactive(ctx);
        logger.info("channelInactive end ....");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)

        //super.channelRead(ctx , msg);
        logger.info("channelRead begin ....");
        // Discard the received data silently.
        try {
//            ByteBuf bf = (ByteBuf) msg;
//            System.out.print("recieved data is : ");
//            while (bf.isReadable()) {
//                System.out.print((char) bf.readByte());
//            }
//            System.out.println(";");
//            System.out.flush();
            // Do something with msg

            ctx.write(msg); // (1)
            ctx.flush(); // (2)
        } finally {
            //ReferenceCountUtil.release(msg);
        }
        logger.info("channelRead end ....");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelReadComplete begin ....");
        super.channelReadComplete(ctx);
        logger.info("channelReadComplete end ....");

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        logger.info("userEventTriggered begin {} .... " , evt);
        super.userEventTriggered(ctx, evt);
        logger.info("userEventTriggered end ....");

    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelWritabilityChanged begin .... ");
        super.channelWritabilityChanged(ctx);
        logger.info("channelWritabilityChanged end ....");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        //super.exceptionCaught(ctx , cause);
        // Close the connection when an exception is raised.
        logger.info("exceptionCaught begin .... ");
        cause.printStackTrace();
        ctx.close();
        logger.info("exceptionCaught end ....");

    }
}
