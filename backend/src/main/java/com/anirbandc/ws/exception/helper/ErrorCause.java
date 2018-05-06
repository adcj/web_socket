package com.anirbandc.ws.exception.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * This ENUM holds the error cause details for all validation errors 
 * caught by following annotations:
 * <ul>
 * <li><b>Size</b></li>
 * <li><b>NotNull</b></li>
 * <li><b>NotEmpty</b></li>
 * </ul>
 * These details are used to construct instances of {@link ExceptionDetail} class. 
 * The same is also used by {@link ValidationErrorBuilder} class for the same 
 * purposes.
 * 
 * @author Anirban DC
 */
public enum ErrorCause {
	/* Internal error */
	NA("NA", "[CRITICAL] No additional details available for this error"),
	PERSIST_ERROR("SAVE FAILED", "[CRITICAL] There was an error while persisting data. Internal error. Pleae try again later"),
	
	/* Error from user/client input */
	MESSAGE("MESSAGE", "Message is missing/invalid. Please provide valid message."),
	
	/* Special error cause: First part of the cause will be concatenated dynamically. */
	FIELD_LENGTH("FIELD_LENGTH", " field length/size exceeded permitted length. Please provide input within permitted length."),
	NULL_FIELD("NULL_FIELD", " field cannot be set to null. Please provide valid input.");
    
	private String message;
	private String desc;
	
	private static Map<String, ErrorCause> nameIndex = new HashMap<>();
	
	static {
		for(ErrorCause errorCause : ErrorCause.values()) {
			nameIndex.put(errorCause.name(), errorCause);
		}
	}
	
	/**
	 * 
	 * @param message
	 * @param desc
	 */
	private ErrorCause(final String message, final String desc) {		
		this.message = message;		
		this.desc = desc;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * Find ErrorCause by name
	 * 
	 * @param message
	 * @return ErrorCause
	 */
	public static ErrorCause findByName(final String name){
		return nameIndex.get(name);
	}
	
	/**
	 * Find ErrorCause by message
	 * 
	 * @param message
	 * @return ErrorCause
	 */
	public static ErrorCause findByMessage(final String message){
		for (ErrorCause errorCause : values()){
			if(errorCause.message.equalsIgnoreCase(message)){
				return errorCause;
			}
		}
		
		return null;
	}
}
