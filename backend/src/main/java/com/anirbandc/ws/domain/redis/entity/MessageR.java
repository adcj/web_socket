package com.anirbandc.ws.domain.redis.entity;

public class MessageR {
	private String timestamp;

	private Object message;

	public MessageR() {
		/* Default Constructor */
	}

	/**
	 * @param message
	 */
	public MessageR(final String timestamp, final Object message) {
		this.timestamp = timestamp;
		this.message = message;
	}

	/**
	 * @return timestamp
	 */
	public final String getTimestamp() {
		return timestamp;
	}

	/**
	 * @return message
	 */
	public final Object getMessage() {
		return message;
	}

	/**
	 * @param timestamp
	 */
	public final void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @param message
	 */
	public final void setMessage(Object message) {
		this.message = message;
	}
}
