package com.anirbandc.ws.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * This class exposes a method for logging class and respective method specific
 * activities. The logs will be recorded/displayed using a predefined format as
 * stated below.
 * 
 * @author Anirban DC
 */
public class AppLog {
	private final Logger logger;

	/**
	 * Initializes logger for each class that requires application level logging
	 * 
	 * @param appClass
	 */
	public AppLog(final Class<?> appClass) {
		this.logger = Logger.getLogger(appClass.getSimpleName());
	}

	/**
	 * This method records/displays log in the following format:
	 * 
	 * <pre>
	 * Method Name() ==> Logged message
	 * </pre>
	 * 
	 * @param level
	 * @param methodName
	 * @param logMessage
	 */
	public void printLog(final Level level, final String methodName, final String logMessage) {
		String logMessageBody = methodName + "() ==> " + logMessage;

		logger.log(level, logMessageBody);
	}
}
