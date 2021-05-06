package cn.itcast.myrpc.order;

import cn.itcast.myrpc.core.server.NettyServer;

public class MyServer {

    public static void main(String[] args) {
        NettyServer.start("127.0.0.1", 5566);
    }

}
