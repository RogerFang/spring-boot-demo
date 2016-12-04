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
        // broadcast: 注册一个endpoint
        stompEndpointRegistry.addEndpoint("/endpointRoger").withSockJS();
        // point2point: 注意一个endpoint
        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS();
    }

    /**
     * 配置消息代理(Message Broker)
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //super.configureMessageBroker(registry);

        //广播式：服务端有消息时，将消息发送给所有连接了当前endpoint的浏览器
        // enable a simple memory-based message broker to carry the messages back to the client on destinations prefixed with "/topic".
        registry.enableSimpleBroker("/topic", "/queue"); // broadcast: "/topic"消息代理; point2point: "/queue"
        // designates the "/app" prefix for messages that are bound for @MessageMapping-annotated methods. This prefix will be used to define all the message mappings
        registry.setApplicationDestinationPrefixes("/app");
    }
}
