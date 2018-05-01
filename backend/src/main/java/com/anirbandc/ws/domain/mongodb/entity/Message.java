/**
 * 
 */
package com.anirbandc.ws.domain.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "message")
public class Message {
	@Id
	private String id;

	@Field("message")
	private Object message;

	public Message() {
		/* Default Constructor */
	}

	/**
	 * @param message
	 */
	public Message(final Object message) {
		this.message = message;
	}

	/**
	 * @return id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * @return message
	 */
	public final Object getMessage() {
		return message;
	}

	/**
	 * @param id
	 */
	public final void setId(String id) {
		this.id = id;
	}

	/**
	 * @param message
	 */
	public final void setMessage(Object message) {
		this.message = message;
	}
}
