package com.anirbandc.ws.web.message;

/**
 * Extends {@link AbstractResponse}<br/>
 * This class serves as the template for all success response messages
 * 
 * @author Anirban DC
 */
public class GenericSuccessResponse extends AbstractResponse {
	/**
	 * Default success response constructor
	 * 
	 * @param message
	 */
	public GenericSuccessResponse(final String message) {
		super.setStatus("OK");
		super.setStatusMessage(message);
	}
}
