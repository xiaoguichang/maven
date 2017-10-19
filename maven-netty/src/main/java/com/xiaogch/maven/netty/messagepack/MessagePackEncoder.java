package com.xiaogch.maven.netty.messagepack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/14 18:01 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class MessagePackEncoder  extends MessageToByteEncoder<Object> {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void encode(ChannelHandlerContext arg0, Object arg1, ByteBuf arg2) throws Exception {
        MessagePack msgpack=new MessagePack();
        byte[] raw=msgpack.write(arg1);
        arg2.writeBytes(raw);
    }
}