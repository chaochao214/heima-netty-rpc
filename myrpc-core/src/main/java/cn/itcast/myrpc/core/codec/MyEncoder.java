package cn.itcast.myrpc.core.codec;

import cn.itcast.myrpc.core.base.BaseRpcBean;
import cn.itcast.myrpc.core.util.HessianSerializer;
import cn.itcast.myrpc.core.util.MySerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 */
public class MyEncoder extends MessageToByteEncoder<BaseRpcBean> {


    private static MySerializer hessianSerializer = new HessianSerializer();

    @Override
    protected void encode(ChannelHandlerContext ctx, BaseRpcBean msg, ByteBuf out) throws Exception {
        byte[] bytes = hessianSerializer.serialize(msg);

        out.writeInt(bytes.length);
        out.writeBytes(bytes);
    }
}
