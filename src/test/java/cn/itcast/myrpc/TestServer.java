package cn.itcast.myrpc;

import cn.itcast.myrpc.server.MyRPCServer;
import org.junit.Test;

public class TestServer {

    @Test
    public void testServer() throws Exception{
        System.setProperty("io.netty.noUnsafe", "true");

//        System.setProperty("io.netty.allocator.type", "unpooled");

        MyRPCServer myRPCServer = new MyRPCServer();

        myRPCServer.start(5566);
    }

}