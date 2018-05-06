package com.anirbandc.ws.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class provides the format of each new message to be consumed by the
 * server.<br/>
 * <b>Validations:</b>
 * <ul>
 * <li><b>Size</b>: Message string size cannot be more than 255 characters. Else
 * a custom error will be thrown.</li>
 * <li><b>Not null</b>: Message string cannot be null. Else a custom error will
 * be thrown.</li>
 * <li><b>Not empty</b>: Message string cannot be empty. Else a custom error
 * will be thrown.</li>
 * </ul>
 * 
 * @author Anirban DC
 */
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
