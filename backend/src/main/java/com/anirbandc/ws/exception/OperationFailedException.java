package com.anirbandc.ws.exception;

import com.anirbandc.ws.exception.base.AppTechnicalException;
import com.anirbandc.ws.exception.helper.ExceptionDetail;
import com.anirbandc.ws.util.AppConstant;

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
