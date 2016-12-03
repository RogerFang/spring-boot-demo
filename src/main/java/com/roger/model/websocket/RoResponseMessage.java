package com.roger.model.websocket;

/**
 * 服务端 -> 浏览器 发送的消息
 * Created by Roger on 2016/12/3.
 */
public class RoResponseMessage {

    private String rspMsg;

    public RoResponseMessage(String rspMsg) {
        this.rspMsg = rspMsg;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }
}
