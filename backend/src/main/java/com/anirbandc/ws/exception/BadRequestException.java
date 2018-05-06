package com.anirbandc.ws.exception;

import com.anirbandc.ws.exception.base.AppBusinessException;
import com.anirbandc.ws.exception.helper.ExceptionDetail;
import com.anirbandc.ws.util.AppConstant;

/**
 * This class can be used throw custom (runtime) bad request exception. HTTP
 * status code for this type of exception will be 400
 * 
 * @author Anirban DC
 */
public class BadRequestException extends AppBusinessException {
	private static final long serialVersionUID = 5951927527132322535L;

	/**
	 * 
	 * @param exceptionDetail
	 */
	public BadRequestException(final ExceptionDetail exceptionDetail) {
		super(exceptionDetail, AppConstant.HTTP_STATUS_BAD_REQUEST);
	}
}
