package com.anirbandc.ws.exception.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.anirbandc.ws.exception.UnprocessableEntityException;
import com.anirbandc.ws.util.AppConstant;

/**
 * This class parses the custom error messages for the following annotations in
 * request bodies:
 * <ul>
 * <li><b>Size</b></li>
 * <li><b>NotNull</b></li>
 * <li><b>NotEmpty</b></li>
 * </ul>
 * In short it processes all errors captured by
 * {@link MethodArgumentNotValidException}<br/>
 * Once processed, returns an instance of {@link UnprocessableEntityException}
 * class with appropriate error details.<br/>
 * Uses Builder design pattern
 * 
 * @author Anirban DC
 */
public class ValidationErrorBuilder {
	/**
	 * Default constructor
	 */
	private ValidationErrorBuilder() {
		/* Default Constructor (Private) */
	}

	/**
	 * Constructs and returns application level bad request exception
	 * 
	 * @param errors
	 * @return BadRequestException
	 */
	public static UnprocessableEntityException fromBindingErrors(final Errors errors) {
		List<String> messageParts = new ArrayList<>();

		String errorObjMsg = errors.getAllErrors().get(0).getDefaultMessage();

		if (errorObjMsg == null || errorObjMsg.isEmpty()) {
			ErrorCause errorCause = getErrorCause(null);

			ExceptionDetail exceptionDetail = new ExceptionDetail(errorCause.getMessage(), errorCause.getDesc());

			throw new UnprocessableEntityException(exceptionDetail);
		}

		if (errorObjMsg.contains(AppConstant.ANNOTATION_MESSAGE_DELIMITER)) {
			String[] parts = errorObjMsg.split(AppConstant.ANNOTATION_MESSAGE_DELIMITER);

			for (int i = 0; i < parts.length; i++) {
				messageParts.add(parts[i]);
			}
		} else {
			messageParts.add(errorObjMsg);
		}

		return constructBadRequestException(messageParts);
	}

	/**
	 * Construct bad request exception from messageParts
	 * 
	 * @param messageParts
	 * @return BadRequestException
	 */
	private static UnprocessableEntityException constructBadRequestException(final List<String> messageParts) {
		ErrorCause errorCause = getErrorCause(null);

		ExceptionDetail exceptionDetail = new ExceptionDetail(errorCause.getMessage(), errorCause.getDesc());

		if (messageParts.isEmpty() || messageParts.size() > 3) {
			return new UnprocessableEntityException(exceptionDetail);
		}

		if (messageParts.size() == 1) {
			exceptionDetail = constructExceptionFromCause(messageParts.get(0));
		}

		if (messageParts.size() == 2) {
			exceptionDetail = constructExceptionFromNameAndCause(messageParts.get(0), messageParts.get(1));
		}

		if (messageParts.size() == 3) {
			exceptionDetail = constructExceptionFromErrorNameAndCauseAndField(messageParts.get(0), messageParts.get(1),
					messageParts.get(2));
		}

		return new UnprocessableEntityException(exceptionDetail);
	}

	/**
	 * Construct exception details from error cause
	 * 
	 * @param cause
	 * @return BadRequestException
	 */
	private static ExceptionDetail constructExceptionFromCause(final String cause) {
		ErrorCause errorCause = getErrorCause(cause);

		return new ExceptionDetail(errorCause.getMessage(), errorCause.getDesc());
	}

	/**
	 * Construct exception details from error name and cause
	 * 
	 * @param name
	 * @param cause
	 * @return BadRequestException
	 */
	private static ExceptionDetail constructExceptionFromNameAndCause(final String name, final String cause) {
		ErrorCause errorCause = getErrorCause(cause);
		ResponseCode responseCode = getResponseCode(name);

		return new ExceptionDetail(responseCode.getReason(), errorCause.getDesc());
	}

	/**
	 * Construct exception details from error name, cause and field name
	 * 
	 * @param name
	 * @param cause
	 * @param fieldName
	 * @return ExceptionDetail
	 */
	private static ExceptionDetail constructExceptionFromErrorNameAndCauseAndField(final String name,
			final String cause, final String fieldName) {
		ResponseCode responseCode = getResponseCode(name);
		ErrorCause errorCause = getErrorCause(cause);

		ExceptionDetail exceptionDetail = new ExceptionDetail(responseCode.getReason(), errorCause.getDesc());

		if (fieldName != null && !fieldName.isEmpty()) {
			exceptionDetail.setCauseDesc(fieldName + errorCause.getDesc());
		}

		return exceptionDetail;
	}

	/**
	 * Construct response code
	 * 
	 * @param name
	 * @return String: error code
	 */
	private static ResponseCode getResponseCode(final String name) {
		ResponseCode responseCode = ResponseCode.UNCAUGHT;

		if (name == null || name.isEmpty()) {
			return responseCode;
		}

		if (ResponseCode.findByName(name) != null) {
			responseCode = ResponseCode.valueOf(name.toUpperCase(Locale.ENGLISH));
		}

		return responseCode;
	}

	/**
	 * Construct error cause
	 * 
	 * @param cause
	 * @return ErrorCause
	 */
	private static ErrorCause getErrorCause(final String cause) {
		ErrorCause errorCause = ErrorCause.NA;

		if (cause == null || cause.isEmpty()) {
			return errorCause;
		}

		if (ErrorCause.findByMessage(cause) != null) {
			errorCause = ErrorCause.findByMessage(cause);
		}

		return errorCause;
	}
}
