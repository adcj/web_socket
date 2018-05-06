package com.anirbandc.ws.exception.helper;

import com.anirbandc.ws.util.AppUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class holds error details for all error responses returned by the
 * server.
 * <ul>
 * <li><b>cause:</b> Short description of the error. This is initialized with
 * appropriate message field of {@link ErrorCause} ENUM</li>
 * <li><b>causeDesc:</b> Actual cause of the error. This is initialized with
 * appropriate desc (description) field of {@link ErrorCause} ENUM</li>
 * <li><b>date:</b> Server date, referring to the date when the error occurred</li>
 * <li><b>time:</b> Server time, referring to the time when the error occurred</li>
 * <li><b>time:</b> Server timestamp, referring to the timestamp when the error occurred</li>
 * </ul>
 * These details are mostly used for recording a human readable format of the
 * cause of error.
 * 
 * @author Anirban DC
 */
public class ExceptionDetail {
	@JsonProperty("cause")
	private String cause;

	@JsonProperty("cause_desc")
	private String causeDesc;

	@JsonProperty("error_date")
	private String date;

	@JsonProperty("error_time")
	private String time;

	@JsonProperty("error_timestamp")
	private String timestamp;

	/**
	 * @param cause
	 * @param causeDesc
	 */
	public ExceptionDetail(final String cause, final String causeDesc) {
		this.cause = cause;
		this.causeDesc = causeDesc;

		this.date = AppUtil.getCurrentDate();
		this.time = AppUtil.getCurrentTime();
		this.timestamp = AppUtil.getCurrentTimestamp();
	}

	/**
	 * @return cause
	 */
	public final String getCause() {
		return cause;
	}

	/**
	 * @return causeDesc
	 */
	public final String getCauseDesc() {
		return causeDesc;
	}

	/**
	 * @return date
	 */
	public final String getDate() {
		return date;
	}

	/**
	 * @return time
	 */
	public final String getTime() {
		return time;
	}

	/**
	 * @return timestamp
	 */
	public final String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param cause
	 */
	public final void setCause(String cause) {
		this.cause = cause;
	}

	/**
	 * @param causeDesc
	 */
	public final void setCauseDesc(String causeDesc) {
		this.causeDesc = causeDesc;
	}

	/**
	 * @param date
	 */
	public final void setDate(String date) {
		this.date = date;
	}

	/**
	 * @param time
	 */
	public final void setTime(String time) {
		this.time = time;
	}

	/**
	 * @param timestamp
	 */
	public final void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
