package cn.itcast.myrpc.test.codec.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class NettyHttpServer {

    public static void main(String[] args) throws Exception {

        // 主线程，不处理任何业务逻辑，只是接收客户的连接请求
        EventLoopGroup boss = new NioEventLoopGroup(1);
        // 工作线程，线程数默认是：cpu*2
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            // 服务器启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, worker);
            //配置server通道
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline()
                            .addLast(new HttpRequestDecoder()) //http请求的解码器
                            //将http请求中的uri以及请求体聚合成一个完整的FullHttpRequest对象
                            .addLast(new HttpObjectAggregator(1024 * 128))
                            .addLast(new HttpResponseEncoder()) //http响应的编码器
                            .addLast(new ChunkedWriteHandler()) //支持异步的大文件传输，防止内存溢出
                            .addLast(new ServerHandler());
                }
            }); //worker线程的处理器

            ChannelFuture future = serverBootstrap.bind(8080).sync();
            System.out.println("服务器启动完成。。。。。");

            //等待服务端监听端口关闭
            future.channel().closeFuture().sync();
        } finally {
            //优雅关闭
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
