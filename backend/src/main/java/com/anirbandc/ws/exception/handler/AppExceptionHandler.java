package com.anirbandc.ws.exception.handler;

import org.apache.log4j.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.anirbandc.ws.exception.UnprocessableEntityException;
import com.anirbandc.ws.exception.base.AppException;
import com.anirbandc.ws.exception.helper.ExceptionDetail;
import com.anirbandc.ws.exception.helper.ResponseCode;
import com.anirbandc.ws.exception.helper.ValidationErrorBuilder;
import com.anirbandc.ws.util.AppConstant;
import com.anirbandc.ws.util.AppLog;
import com.anirbandc.ws.util.AppUtil;
import com.anirbandc.ws.web.message.AbstractResponse;
import com.anirbandc.ws.web.message.GenericErrorResponse;

@ControllerAdvice(annotations = RestController.class)
public class AppExceptionHandler {
	private final String RESPONSE_PREFIX = "Response >> ";
	private final AppLog appLog = new AppLog(getClass());

	/**
	 * Catch application level custom exceptions and returns error response
	 * 
	 * @param appException
	 * @return AbstractResponse: instance of GenericErrorResponse
	 */
	@ExceptionHandler(value = AppException.class)
	public ResponseEntity<AbstractResponse> handleApiException(final AppException appException) {
		String methodName = "handleApiException";

		ExceptionDetail exceptionDetail = appException.getExceptionDetail();
		int httpStatusCode = appException.getHttpStatusCode();

		GenericErrorResponse genericErrorResponse = new GenericErrorResponse(exceptionDetail, httpStatusCode);

		appLog.printLog(Level.ERROR, methodName, RESPONSE_PREFIX + AppUtil.convertObjectToJson(genericErrorResponse));

		return ResponseEntity.status(AppConstant.APP_HTTP_ERROR_CODE.get(httpStatusCode)).body(genericErrorResponse);
	}

	/**
	 * Catch custom input (JSON) validation errors and return appropriate error
	 * 
	 * @param exception
	 * @return AbstractResponse: instance of GenericErrorResponse
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<AbstractResponse> handleMethodArgumentNotValidException(final Exception exception) {
		String methodName = "handleMethodArgumentNotValidException";

		UnprocessableEntityException error = createValidationError(exception);

		int httpStatusCode = error.getHttpStatusCode();

		ExceptionDetail exceptionDetail = error.getExceptionDetail();

		GenericErrorResponse genericErrorResponse = new GenericErrorResponse(exceptionDetail, httpStatusCode);

		appLog.printLog(Level.ERROR, methodName, RESPONSE_PREFIX + AppUtil.convertObjectToJson(genericErrorResponse));

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(genericErrorResponse);
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<AbstractResponse> handleMessageNotReadableException(final Exception exception) {
		String methodName = "handleMessageNotReadableException";

		ExceptionDetail exceptionDetail = new ExceptionDetail(ResponseCode.PARSE_ERROR.getMessage(),
				ResponseCode.PARSE_ERROR.getReason());

		GenericErrorResponse genericErrorResponse = new GenericErrorResponse(exceptionDetail,
				AppConstant.HTTP_STATUS_BAD_REQUEST);

		appLog.printLog(Level.ERROR, methodName, RESPONSE_PREFIX + AppUtil.convertObjectToJson(genericErrorResponse));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericErrorResponse);
	}

	/**
	 * Catch application level global Exception and returns error response
	 * 
	 * @param exception
	 * @return AbstractResponse: instance of GenericErrorResponse
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<AbstractResponse> handleException(final Exception exception) {
		String methodName = "handleException";

		exception.printStackTrace();

		ExceptionDetail exceptionDetail = new ExceptionDetail(ResponseCode.UNCAUGHT.getReason(),
				exception.getMessage());

		GenericErrorResponse genericErrorResponse = new GenericErrorResponse(exceptionDetail,
				AppConstant.HTTP_STATUS_INTERNAL_SERVER_ERROR);

		appLog.printLog(Level.ERROR, methodName, RESPONSE_PREFIX + AppUtil.convertObjectToJson(genericErrorResponse));

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(genericErrorResponse);
	}

	/**
	 * Construct and returns application level bad request exception
	 * 
	 * @param exception
	 * @return BadRequestException
	 */
	private UnprocessableEntityException createValidationError(final Exception exception) {
		return ValidationErrorBuilder
				.fromBindingErrors(((MethodArgumentNotValidException) exception).getBindingResult());
	}
}
