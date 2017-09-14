package com.xiaogch.maven.netty.messagepack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/14 18:01 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class MessagePackEncoder extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        MessagePack messagePack = new MessagePack();
        byte[] result = messagePack.write(o);
        byteBuf.writeBytes(result);
    }
}
