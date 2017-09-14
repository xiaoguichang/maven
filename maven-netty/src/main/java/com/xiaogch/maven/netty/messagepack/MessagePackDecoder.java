package com.xiaogch.maven.netty.messagepack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/14 18:04 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class MessagePackDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {


    }
}
