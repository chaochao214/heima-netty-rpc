package cn.itcast.myrpc.test.tcppackage2;

public class MyProtocol {

    private Integer length; //数据头：长度

    private byte[] body; //数据体

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}