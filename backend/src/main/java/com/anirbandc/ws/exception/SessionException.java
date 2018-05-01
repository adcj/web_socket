package com.anirbandc.ws.exception;

import com.anirbandc.ws.exception.base.AppBusinessException;
import com.anirbandc.ws.exception.helper.ExceptionDetail;
import com.anirbandc.ws.util.AppConstant;

public class SessionException extends AppBusinessException {
	private static final long serialVersionUID = 5951927527132322535L;

	/**
	 * 
	 * @param exceptionDetail
	 */
	public SessionException(final ExceptionDetail exceptionDetail) {
		super(exceptionDetail, AppConstant.HTTP_STATUS_UNAUTHORIZED);
	}
}
