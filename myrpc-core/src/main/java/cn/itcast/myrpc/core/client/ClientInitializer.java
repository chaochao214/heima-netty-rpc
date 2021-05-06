package cn.itcast.myrpc.core.client;

import cn.itcast.myrpc.core.base.RpcResponse;
import cn.itcast.myrpc.core.codec.MyDecoder;
import cn.itcast.myrpc.core.codec.MyEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ClientInitializer extends ChannelInitializer<SocketChannel> {

    private static final ClientHandler CLIENT_HANDLER = new ClientHandler();

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
            .addLast(new MyDecoder(RpcResponse.class))
            .addLast(new MyEncoder())
            .addLast(CLIENT_HANDLER);
    }
}