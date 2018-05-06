package com.anirbandc.ws.exception.base;

import com.anirbandc.ws.exception.helper.ExceptionDetail;

/**
 * Extends {@link AppException}<br/>
 * This abstract class serves as the template for all technical exceptions.
 * 
 * @author Anirban DC
 */
public abstract class AppTechnicalException extends AppException {
	private static final long serialVersionUID = -6538006142999778827L;

	/**
	 * Constructor for technical exception
	 * 
	 * @param exceptionDetail
	 * @param httpStatusCode
	 */
	public AppTechnicalException(final ExceptionDetail exceptionDetail, final int httpStatusCode) {
		super(exceptionDetail, httpStatusCode);
	}
}
