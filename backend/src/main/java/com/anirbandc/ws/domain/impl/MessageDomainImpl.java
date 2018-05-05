/**
 * 
 */
package com.anirbandc.ws.domain.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anirbandc.ws.domain.MessageDomain;
import com.anirbandc.ws.domain.mongodb.entity.Message;
import com.anirbandc.ws.domain.mongodb.repo.MessageRepo;
import com.anirbandc.ws.domain.redis.entity.MessageR;
import com.anirbandc.ws.domain.redis.repo.MessageRRepo;
import com.anirbandc.ws.dto.MessageDTO;
import com.anirbandc.ws.util.AppUtil;

/**
 * Implementation of {@link MessageDomain} interface methods
 * 
 * @author Anirban DC
 *
 */
@Component("messageDomain")
public class MessageDomainImpl implements MessageDomain {
	@Autowired(required = true)
	private MessageRepo messageRepo;

	@Autowired(required = true)
	private MessageRRepo messageRRepo;

	public MessageDomainImpl() {
		/* Default constructor */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.falconio.dpp.domain.MessageDomain#addMessageToRedis()
	 */
	@Override
	public void addMessageToRedis(final MessageDTO messageDTO) {
		MessageR messageR = new MessageR(AppUtil.getCurrentTimestamp(), messageDTO);

		messageRRepo.addMessage(messageR);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.falconio.dpp.domain.MessageDomain#addMessageToMongoDB()
	 */
	@Override
	public void addMessageToMongoDB(final Object message) {
		messageRepo.save(new Message(message));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.falconio.dpp.domain.MessageDomain#getAllMessage()
	 */
	@Override
	public Object getAllMessage() {
		List<Message> messages = messageRepo.findAll();

		if (messages == null || messages.isEmpty()) {
			return null;
		}

		return messages;
	}
}
