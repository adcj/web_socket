package com.anirbandc.ws.exception;

import com.anirbandc.ws.exception.base.AppTechnicalException;
import com.anirbandc.ws.exception.handler.AppExceptionHandler;
import com.anirbandc.ws.exception.helper.ExceptionDetail;
import com.anirbandc.ws.util.AppConstant;

/**
 * This class can be used throw custom (runtime) request failed exception. HTTP
 * status code for this type of exception will be 500<br/>
 * 
 * <b>Note:</b> This is a special type of exception. Any caught server internal
 * exception should throw this exception. Uncaught ones will be handled by
 * {@link AppExceptionHandler}.
 * 
 * @author Anirban DC
 */
public class OperationFailedException extends AppTechnicalException {
	private static final long serialVersionUID = -6538006142999778827L;

	/**
	 * 
	 * @param exceptionDetail
	 */
	public OperationFailedException(final ExceptionDetail exceptionDetail) {
		super(exceptionDetail, AppConstant.HTTP_STATUS_INTERNAL_SERVER_ERROR);
	}
}
