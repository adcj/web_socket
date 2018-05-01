/**
 * 
 */
package com.anirbandc.ws.service;

import com.anirbandc.ws.dto.MessageDTO;
import com.anirbandc.ws.web.message.AbstractResponse;
import com.anirbandc.ws.web.message.GenericSuccessResponse;
import com.anirbandc.ws.web.message.response.MessageListResponse;

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
