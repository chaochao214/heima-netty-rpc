package cn.itcast.myrpc.core.codec;

import cn.itcast.myrpc.core.base.BaseRpcBean;
import cn.itcast.myrpc.core.util.HessianSerializer;
import cn.itcast.myrpc.core.util.MySerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * 解码器
 */
public class MyDecoder<T extends BaseRpcBean> extends ReplayingDecoder<Void> {

    private static MySerializer hessianSerializer = new HessianSerializer();

    private Class<T> clazz;

    public MyDecoder(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        byte[] bytes = new byte[in.readInt()];
        in.readBytes(bytes);

        BaseRpcBean rpcBean = hessianSerializer.deserialize(bytes, clazz);
        out.add(rpcBean);
    }
}