package com.anirbandc.ws.domain;

import com.anirbandc.ws.dto.MessageDTO;

/**
 * Interface between business layer and database layer.<br/>
 * 
 * The purpose of this interface is to:<br/>
 * 1. Receive MongoDB and/or Redis CRUD requests from business layer<br/>
 * 2. Process and transform the requests into respective JPA repository query
 * formats<br/>
 * 3. Invoke (JPA) repository query methods<br/>
 * 4. Translate database query result into respective format(s) relevant to the
 * business layer(s)<br/>
 * 5. Return translated result back to respective caller (business layer) method
 * 
 * @author Anirban DC
 */
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
