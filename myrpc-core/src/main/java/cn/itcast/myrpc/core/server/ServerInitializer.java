package cn.itcast.myrpc.core.server;

import cn.itcast.myrpc.core.base.RpcRequest;
import cn.itcast.myrpc.core.codec.MyDecoder;
import cn.itcast.myrpc.core.codec.MyEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new MyDecoder(RpcRequest.class)) //解码器，需要解码的对象是RpcRequest
                .addLast(new MyEncoder()) //编码器，用于数据的响应
                .addLast(new ServerHandler()); //自定义逻辑
    }
}
