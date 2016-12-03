package com.roger.web.websocket;

import com.roger.model.websocket.RoMessage;
import com.roger.model.websocket.RoResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * WebSocket：双工异步通信
 * 直接使用WebSocket协议开发繁琐，浏览器会不兼容
 * 解决办法：使用SockJS模拟WebSocket协议，基于它的子协议STOMP(一个基于帧的格式来定义消息)
 * Created by Roger on 2016/12/3.
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketController {

    /**
     * 广播式：服务端有消息时，将消息发送给所有连接了当前endpoint的浏览器
     * @param roMessage
     * @return
     * @throws InterruptedException
     */
    @MessageMapping("/send") // @MessageMapping类似@RequestMapping, 浏览器 -> 服务端 映射地址
    @SendTo("/topic/response") // 当服务端有消息时, 会对订阅了@SendTo中的路径的浏览器发送消息
    public RoResponseMessage broadcastSay(RoMessage roMessage) throws InterruptedException {
        System.out.println(roMessage);
        Thread.sleep(3000);
        return new RoResponseMessage("Server: Welcome, " + roMessage.getName() + "! " +System.currentTimeMillis());
    }
}
