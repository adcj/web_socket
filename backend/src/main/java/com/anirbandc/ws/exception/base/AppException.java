package com.anirbandc.ws.exception.base;

import com.anirbandc.ws.exception.helper.ExceptionDetail;
import com.anirbandc.ws.util.AppConstant;

/**
 * Extends {@link RuntimeException}<br/>
 * Template class for all custom (runtime) errors thrown by the server.<br/>
 * <b>{@link ExceptionDetail}</b>: Contains details with respect to the
 * error.<br/>
 * <b>httpStatusCode</b>: Custom code related to appropriate HTTP status code.
 * Refer to {@link AppConstant} APP_HTTP_ERROR_CODE variable.
 * 
 * @author Anirban DC
 */
public abstract class AppException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private ExceptionDetail exceptionDetail;

	private int httpStatusCode;

	/**
	 * Default constructor
	 */
	public AppException() {
		super();
	}

	/**
	 * 
	 * @param exceptionDetail
	 * @param httpStatusCode
	 */
	public AppException(final ExceptionDetail exceptionDetail, final int httpStatusCode) {
		super();

		this.exceptionDetail = exceptionDetail;
		this.httpStatusCode = httpStatusCode;
	}

	/**
	 * @return the exceptionDetail
	 */
	public ExceptionDetail getExceptionDetail() {
		return exceptionDetail;
	}

	/**
	 * @return the httpStatusCode
	 */
	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	/**
	 * @param exceptionDetail
	 *            the exceptionDetail to set
	 */
	public void setExceptionDetail(ExceptionDetail exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}

	/**
	 * @param httpStatusCode
	 *            the httpStatusCode to set
	 */
	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
}
