package com.anirbandc.ws.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class exposes common utility methods.
 * 
 * @author Anirban DC
 */
public class AppUtil {
	private AppUtil() {
		/* Default Constructor (Private) */
	}

	/**
	 * Convert POJO to JSON String
	 * 
	 * @param object
	 * @return JSON object as string
	 */
	public static String convertObjectToJson(final Object object) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(object);
		} catch (IOException exception) {
			return null;
		}
	}

	/**
	 * Return current server date
	 * 
	 * @return String: current date
	 */
	public static String getCurrentDate() {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(AppConstant.DATE_FORMAT);

		return dateFormat.format(today);
	}

	/**
	 * Return current server time
	 * 
	 * @return String: current time
	 */
	public static String getCurrentTime() {
		Date today = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat(AppConstant.HR_24_TIME_FORMAT);

		return timeFormat.format(today);
	}

	/**
	 * Return current server timestamp
	 * 
	 * @return String: current time stamp
	 */
	public static String getCurrentTimestamp() {
		long systemTimeMillis = System.currentTimeMillis();
		long systemTimeSeconds = TimeUnit.MILLISECONDS.toSeconds(systemTimeMillis);

		return Long.toString(systemTimeSeconds);
	}
}
