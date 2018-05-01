package com.anirbandc.ws.web.message;

public class GenericSuccessResponse extends AbstractResponse {
	/**
	 * Default success response constructor
	 */
	public GenericSuccessResponse(final String message) {
		super.setStatus("OK");
		super.setStatusMessage(message);
	}
}
