package com.anirbandc.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import com.anirbandc.ws.util.AppConstant;

/**
 * WebSocket configuration. There are two steps for this:<br/>
 * 1. Add a {@link StompEndpointRegistry} end point<br/>
 * 2. Add a {@link MessageBrokerRegistry} end point<br/>
 * 
 * The second end point will be used to broadcast messages to all clients
 * listening to the same.
 * 
 * @author Anirban DC
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.socket.config.annotation.
	 * WebSocketMessageBrokerConfigurer#registerStompEndpoints(org.
	 * springframework.web.socket.config.annotation.StompEndpointRegistry)
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/socket").setAllowedOrigins("*").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app").enableSimpleBroker(AppConstant.EP_MESSAGE_BROKER);
	}
}
