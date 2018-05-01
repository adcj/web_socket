/**
 * 
 */
package com.anirbandc.ws.domain.mongodb.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.anirbandc.ws.domain.mongodb.entity.Message;

public interface MessageRepo extends MongoRepository<Message, Long> {
}
