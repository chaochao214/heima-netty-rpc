package cn.itcast.myrpc.test.tcppackage2.server;

import cn.itcast.myrpc.test.tcppackage2.MyProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class ServerHandler extends SimpleChannelInboundHandler<MyProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyProtocol msg) throws Exception {
        System.out.println("服务端接收到消息：" + new String(msg.getBody(), CharsetUtil.UTF_8));
        System.out.println("服务端接收到消息数量：" + (++count));

        byte[] data = "ok".getBytes(CharsetUtil.UTF_8);
        MyProtocol myProtocol = new MyProtocol();
        myProtocol.setLength(data.length);
        myProtocol.setBody(data);

        ctx.writeAndFlush(myProtocol);
    }
}