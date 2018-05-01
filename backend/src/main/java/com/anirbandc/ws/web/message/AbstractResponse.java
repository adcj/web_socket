package com.anirbandc.ws.web.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractResponse {
	@JsonProperty("status")
	private String status;

	@JsonProperty("status_message")
	private String statusMessage;

	/**
	 * @return status
	 */
	public final String getStatus() {
		return status;
	}

	/**
	 * @return statusMessage
	 */
	public final String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param status
	 */
	public final void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param statusMessage
	 */
	public final void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
