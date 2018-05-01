package com.anirbandc.ws.exception;

import com.anirbandc.ws.exception.base.AppBusinessException;
import com.anirbandc.ws.exception.helper.ExceptionDetail;
import com.anirbandc.ws.util.AppConstant;

public class UnprocessableEntityException extends AppBusinessException {
	private static final long serialVersionUID = -8921590380374090641L;

	/**
	 * 
	 * @param exceptionDetail
	 */
	public UnprocessableEntityException(final ExceptionDetail exceptionDetail) {
		super(exceptionDetail, AppConstant.HTTP_STATUS_UNPROCESSABLE_ENTITY);
	}
}
