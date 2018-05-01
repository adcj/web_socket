package com.anirbandc.ws.domain.redis.repo.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import com.anirbandc.ws.domain.redis.entity.MessageR;
import com.anirbandc.ws.domain.redis.repo.MessageRRepo;
import com.anirbandc.ws.util.AppConstant;
import com.anirbandc.ws.util.AppUtil;

@Repository
public class MessageRRepoImpl implements MessageRRepo {
	private static final String KEY = "MessageR";

	private final StringRedisTemplate redisTemplate;
	private HashOperations<String, String, String> hashOperations;

	/**
	 * @param redisTemplate
	 */
	@Autowired
	public MessageRRepoImpl(final StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;

		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void addMessage(final MessageR messageR) {
		String ts = messageR.getTimestamp();
		String messageBody = AppUtil.convertObjectToJson(messageR);
		hashOperations.put(KEY, ts, messageBody);

		redisTemplate.convertAndSend(AppConstant.CHANNEL_TOPIC, AppUtil.convertObjectToJson(messageR.getMessage()));
	}

	@Override
	public Map<String, String> getAllMessages() {
		return hashOperations.entries(KEY);
	}
}
