package cn.itcast.myrpc.test.codec.hessian;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class HessianEncoder extends MessageToByteEncoder<User> {

    private HessianSerializer hessianSerializer = new HessianSerializer();

    protected void encode(ChannelHandlerContext ctx, User msg, ByteBuf out) throws Exception {
        byte[] bytes = hessianSerializer.serialize(msg);
        out.writeBytes(bytes);
    }
}