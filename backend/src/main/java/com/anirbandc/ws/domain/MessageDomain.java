/**
 * 
 */
package com.anirbandc.ws.domain;

import com.anirbandc.ws.dto.MessageDTO;

public interface MessageDomain {
	/**
	 * Add/persist new message in Redis
	 * 
	 * @param messageDTO
	 * @return {@link MessageDTO}: persisted message details. NULL if save fails
	 *         (somehow)
	 */
	void addMessageToRedis(MessageDTO messageDTO);

	/**
	 * Persist message in MongoDB
	 * 
	 * @param message
	 */
	void addMessageToMongoDB(Object message);

	/**
	 * Fetch all messages from respective MongoDB tables(s)
	 * 
	 * @return Object or null (if not found)
	 */
	Object getAllMessage();
}
