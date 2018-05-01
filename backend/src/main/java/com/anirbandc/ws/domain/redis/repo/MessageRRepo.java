package com.anirbandc.ws.domain.redis.repo;

import java.util.Map;

import com.anirbandc.ws.domain.redis.entity.MessageR;

public interface MessageRRepo {
	void addMessage(MessageR messageR);

	Map<String, String> getAllMessages();
}
