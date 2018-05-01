package com.anirbandc.ws.web.message;

import com.anirbandc.ws.exception.helper.ExceptionDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericErrorResponse extends AbstractResponse {
	@JsonIgnore
	@JsonProperty("reason")
	private int reason;

	@JsonProperty("error_details")
	private ExceptionDetail exceptionDetail;

	public GenericErrorResponse() {
		super();
	}

	/**
	 * 
	 * @param exceptionDetail
	 * @param httpStatusCode
	 */
	public GenericErrorResponse(final ExceptionDetail exceptionDetail, final int httpStatusCode) {
		this.exceptionDetail = exceptionDetail;

		super.setStatus("FAIL");
		super.setStatusMessage(exceptionDetail.getCause());

		this.reason = httpStatusCode;
	}
}
