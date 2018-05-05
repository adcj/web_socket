package com.anirbandc.ws.service.impl;

import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import com.anirbandc.ws.domain.MessageDomain;
import com.anirbandc.ws.util.AppLog;

/**
 * This service class defines the functionality of onMessage method of (Redis)
 * {@link MessageListener} interface.<br/>
 * <br/>
 * 
 * Whenever a new message is received, onMessage calls
 * {@link MessageDomain}.addMessageToMongoDB() method which in turn persists the
 * message into MongoDB.
 * 
 * @author Anirban DC
 */
@Component("messageConsumer")
public class MessageConsumer implements MessageListener {
	@Autowired
	private MessageDomain messageDomain;

	private final AppLog appLog;

	public MessageConsumer() {
		this.appLog = new AppLog(getClass());
	}

	@Override
	public void onMessage(final Message message, final byte[] pattern) {
		String messageBody = new String(message.getBody());

		appLog.printLog(Level.INFO, "onMessage", "Message received: " + messageBody);

		messageDomain.addMessageToMongoDB(messageBody);
	}
}
