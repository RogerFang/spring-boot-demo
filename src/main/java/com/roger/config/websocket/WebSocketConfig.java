package com.roger.config.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by Roger on 2016/12/3.
 */
@Configuration
@EnableWebSocketMessageBroker // 注解开启使用STOMP协议传输基于代理(Message broker)的消息
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{  // 继承AbstractWebSocketMessageBrokerConfigurer来配置WebSocket

    /**
     * 注册STOMP协议的节点(endpoint), 映射到指定的URL, 并指定使用SockJS协议
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpointRoger").withSockJS();
    }

    /**
     * 配置消息代理(Message Broker)
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //super.configureMessageBroker(registry);

        //广播式：服务端有消息时，将消息发送给所有连接了当前endpoint的浏览器
        registry.enableSimpleBroker("/topic"); // 广播式配置一个"/topic"消息代理
    }
}
