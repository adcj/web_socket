/**
 * 
 */
package com.anirbandc.ws.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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
