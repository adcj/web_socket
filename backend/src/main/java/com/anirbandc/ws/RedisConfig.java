package com.anirbandc.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.anirbandc.ws.service.impl.MessageConsumer;
import com.anirbandc.ws.util.AppConstant;

@Configuration
public class RedisConfig {
	@Autowired
	private MessageConsumer messageConsumer;

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new ChannelTopic(AppConstant.CHANNEL_TOPIC));

		return container;
	}

	@Bean
	MessageListenerAdapter messageListener() {
		return new MessageListenerAdapter(messageConsumer);
	}

	@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}
}
