package com.anirbandc.ws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anirbandc.ws.domain.MessageDomain;
import com.anirbandc.ws.dto.MessageDTO;
import com.anirbandc.ws.service.MessageService;
import com.anirbandc.ws.web.message.AbstractResponse;
import com.anirbandc.ws.web.message.GenericSuccessResponse;
import com.anirbandc.ws.web.message.response.MessageListResponse;

/**
 * Implementation of {@link MessageService} interface methods
 * 
 * @author Anirban DC
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired(required = true)
	private MessageDomain messageDomain;

	public MessageServiceImpl() {
		/* Default Constructor */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.falconio.dpp.service.MessageSearvice#processAndAddMessage(com.
	 * falconio.dpp.dto.MessageDTO)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public AbstractResponse processAndAddMessage(final MessageDTO messageDTO) {
		messageDomain.addMessageToRedis(messageDTO);

		return new GenericSuccessResponse("Message added");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.falconio.dpp.service.MessageSearvice#processAndGetMessages()
	 */
	@Override
	public AbstractResponse processAndGetMessages() {
		Object messages = messageDomain.getAllMessage();

		String message = "No messages found";

		if (messages != null) {
			message = "Messages found";
		}

		return new MessageListResponse(message, messages);
	}
}
