package com.roger.web.websocket;

import com.roger.model.websocket.RoMessage;
import com.roger.model.websocket.RoResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * WebSocket：双工异步通信
 * 直接使用WebSocket协议开发繁琐，浏览器会不兼容
 * 解决办法：使用SockJS模拟WebSocket协议，基于它的子协议STOMP(一个基于帧的格式来定义消息)
 * Created by Roger on 2016/12/3.
 */
@Controller
//@RequestMapping("/websocket")
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping("/point2point")
    public String point2point(){
        return "/websocket/point2point";
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg){
        String username = principal.getName();
        System.out.println("CHAT: username="+username+"; msg="+msg);
        if (username.equals("roger")){
            messagingTemplate.convertAndSendToUser("fanglong", "/queue/notifications", principal.getName()+ "-send:"+msg);
        }else if(username.equals("fanglong")){
            messagingTemplate.convertAndSendToUser("roger", "/queue/notifications", principal.getName()+ "-send:"+msg);
        }
    }

    @RequestMapping("/broadcast")
    public String broadcast(){
        return "websocket/broadcast";
    }

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
