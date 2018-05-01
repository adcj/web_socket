/**
 * 
 */
package com.anirbandc.ws.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDTO {
	@Size(max = 255, message = "INVALID_VALUE~FIELD_LENGTH~message")
	@NotNull(message = "MANDATORY_PARAMETER~MESSAGE")
	@NotEmpty(message = "INVALID_VALUE~MESSAGE")
	@JsonProperty("message")
	private String message;

	public MessageDTO() {
		/* Default Constructor */
	}

	/**
	 * @param message
	 */
	public MessageDTO(final String message) {
		this.message = message;
	}

	/**
	 * @return message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public final void setMessage(String message) {
		this.message = message;
	}
}
