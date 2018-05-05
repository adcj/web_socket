package com.anirbandc.ws.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

/**
 * This class contains all global constants and variables.
 * 
 * @author Anirban DC
 */
public class AppConstant {
	/* Greeting Messages */
	public static final String HOME_CONTROLLER_GREETING = "Welcome to WebSocket (with Redis and MongoDB) sample project.";

	/*
	 * Hash Maps: Must be initialized during Application initialization
	 */
	protected static final Map<Integer, HttpStatus> APP_HTTP_ERROR_CODE = new HashMap<>();

	/* Application Constants */
	public static final String DATE_FORMAT = "MM/dd/yyyy";
	public static final String HR_24_TIME_FORMAT = "HH:mm:ss";
	public static final String ANNOTATION_MESSAGE_DELIMITER = "~";

	/* HTTP Constants */
	public static final int HTTP_STATUS_BAD_REQUEST = 1;
	public static final int HTTP_STATUS_UNAUTHORIZED = 2;
	public static final int HTTP_STATUS_FORBIDDEN = 3;
	public static final int HTTP_STATUS_NOT_FOUND = 4;
	public static final int HTTP_STATUS_UNSUPPORTED_MEDIA_TYPE = 5;
	public static final int HTTP_STATUS_UNPROCESSABLE_ENTITY = 6;
	public static final int HTTP_STATUS_INTERNAL_SERVER_ERROR = 6;

	/* Redis Message */
	public static final String CHANNEL_TOPIC = "msg_queue";

	/* Message End Point */
	public static final String EP_MESSAGE_BROKER = "/newmsg";

	private AppConstant() {
		/* Default Constructor (Private) */
	}

	/**
	 * Retrieve HTTP Status from Hash Map, based on code (defined within the
	 * Hash Map)
	 * 
	 * @param code
	 * @return {@link HttpStatus}
	 */
	public static final HttpStatus getHttpStatusCode(final int code) {
		return APP_HTTP_ERROR_CODE.get(code);
	}

	/**
	 * Initialize HTTP error status codes
	 */
	public static final void setHttpStatusCode() {
		APP_HTTP_ERROR_CODE.put(HTTP_STATUS_BAD_REQUEST, HttpStatus.BAD_REQUEST);
		APP_HTTP_ERROR_CODE.put(HTTP_STATUS_UNAUTHORIZED, HttpStatus.UNAUTHORIZED);
		APP_HTTP_ERROR_CODE.put(HTTP_STATUS_FORBIDDEN, HttpStatus.FORBIDDEN);
		APP_HTTP_ERROR_CODE.put(HTTP_STATUS_NOT_FOUND, HttpStatus.NOT_FOUND);
		APP_HTTP_ERROR_CODE.put(HTTP_STATUS_UNSUPPORTED_MEDIA_TYPE, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		APP_HTTP_ERROR_CODE.put(HTTP_STATUS_UNPROCESSABLE_ENTITY, HttpStatus.UNPROCESSABLE_ENTITY);
		APP_HTTP_ERROR_CODE.put(HTTP_STATUS_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
