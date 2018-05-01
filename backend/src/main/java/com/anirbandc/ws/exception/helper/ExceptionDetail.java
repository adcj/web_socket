package com.anirbandc.ws.exception.helper;

import com.anirbandc.ws.util.AppUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionDetail {
	@JsonProperty("cause")
	private String cause;

	@JsonProperty("cause_desc")
	private String causeDesc;

	@JsonProperty("error_date")
	private String date;

	@JsonProperty("error_time")
	private String time;

	/**
	 * @param cause
	 * @param causeDesc
	 */
	public ExceptionDetail(final String cause, final String causeDesc) {
		this.cause = cause;
		this.causeDesc = causeDesc;

		this.date = AppUtil.getCurrentDate();
		this.time = AppUtil.getCurrentTime();
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
}
