/**
 * 
 */
package com.anirbandc.ws.web.message.response;

import com.anirbandc.ws.web.message.GenericSuccessResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

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
