package com.roger.model.websocket;

/**
 * 浏览器 -> 服务端 发送的消息
 * Created by Roger on 2016/12/3.
 */
public class RoMessage {

    private String name;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RoMessage{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
