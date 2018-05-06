package com.anirbandc.ws.web.message.response;

import com.anirbandc.ws.web.message.GenericSuccessResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class is used for returning the messages stored in MongoDB.<br/>
 * <br/>
 * <b>messages</b>: one or more messages stored in the database. If there are no
 * messages, then this will be set to <b>NULL</b>.
 * 
 * @author Anirban DC
 */
public class MessageListResponse extends GenericSuccessResponse {
	@JsonProperty("result")
	private Object messages;

	/**
	 * @param message
	 */
	public MessageListResponse(final String message, final Object messages) {
		super(message);

		this.messages = messages;
	}

	/**
	 * @return messages
	 */
	public final Object getMessages() {
		return messages;
	}

	/**
	 * @param messages
	 */
	public final void setMessages(Object messages) {
		this.messages = messages;
	}
}
