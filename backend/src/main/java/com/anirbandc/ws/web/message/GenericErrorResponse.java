package com.anirbandc.ws.web.message;

import com.anirbandc.ws.exception.base.AppException;
import com.anirbandc.ws.exception.helper.ExceptionDetail;
import com.anirbandc.ws.util.AppConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Extends {@link AbstractResponse}<br/>
 * This class serves as the template for all error response messages
 * 
 * @author Anirban DC
 */
public class GenericErrorResponse extends AbstractResponse {
	@JsonIgnore
	@JsonProperty("reason")
	private int reason;

	@JsonProperty("error_details")
	private ExceptionDetail exceptionDetail;

	private static final String STATUS = "FAIL";

	/**
	 * Constructor for error response<br/>
	 * <br/>
	 * <b>reason</b>: code for HTTP status indicating cause of error. Code can
	 * be found in {@link AppConstant} APP_HTTP_ERROR_CODE variable. Mainly
	 * comes in handy for {@link AppException} errors.</br>
	 * <b>exceptionDetail</b>: contains more user friendly details with respect
	 * to a given error. Refer to {@link ExceptionDetail} for details.
	 * 
	 * @param exceptionDetail
	 * @param httpStatusCode
	 */
	public GenericErrorResponse(final ExceptionDetail exceptionDetail, final int httpStatusCode) {
		this.exceptionDetail = exceptionDetail;

		super.setStatus(STATUS);
		super.setStatusMessage(exceptionDetail.getCause());

		this.reason = httpStatusCode;
	}
}
