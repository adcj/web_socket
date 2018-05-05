package com.anirbandc.ws.service;

import com.anirbandc.ws.dto.MessageDTO;
import com.anirbandc.ws.web.message.AbstractResponse;
import com.anirbandc.ws.web.message.GenericSuccessResponse;
import com.anirbandc.ws.web.message.response.MessageListResponse;

/**
 * Interface exposing the business layer methods that:<br/>
 * 1. Receives message related requests from appropriate (REST) Controller<br/>
 * 2. Validates and/or processes requests<br/>
 * 3. Calls appropriate domain layer methods for processing CRUD operations<br/>
 * 4. Once result is received from domain layer, translates result into a format
 * understandable by the clients<br/>
 * 5. Returns translated result back to the caller (Controller) method
 * 
 * @author Anirban DC
 */
public interface MessageService {
	/**
	 * Process and persist new message in DB
	 * 
	 * @param messageDTO
	 * @return {@link AbstractResponse}: instance of
	 *         {@link GenericSuccessResponse}
	 */
	AbstractResponse processAndAddMessage(MessageDTO messageDTO);

	/**
	 * Process and fetch all messages (if any) from DB
	 * 
	 * @return {@link AbstractResponse}: instance of {@link MessageListResponse}
	 */
	AbstractResponse processAndGetMessages();
}
