package cn.itcast.myrpc.core.base;

public abstract class BaseRpcBean implements java.io.Serializable{

    private String requestId; //请求id

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
