package com.anirbandc.ws.exception.base;

import com.anirbandc.ws.exception.helper.ExceptionDetail;

/**
 * Extends {@link AppException}<br/>
 * This abstract class serves as the template for all business logic/validation
 * based exceptions.
 * 
 * @author Anirban DC
 */
public abstract class AppBusinessException extends AppException {
	private static final long serialVersionUID = 5951927527132322535L;

	/**
	 * Constructor for business exception
	 * 
	 * @param exceptionDetail
	 * @param httpStatusCode
	 */
	public AppBusinessException(final ExceptionDetail exceptionDetail, final int httpStatusCode) {
		super(exceptionDetail, httpStatusCode);
	}
}
