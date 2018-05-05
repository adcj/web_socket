/**
 * 
 */
package com.anirbandc.ws.domain.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.anirbandc.ws.domain.MessageDomain;
import com.anirbandc.ws.domain.impl.MessageDomainImpl;
import com.anirbandc.ws.domain.mongodb.entity.Message;
import com.anirbandc.ws.domain.mongodb.repo.MessageRepo;
import com.anirbandc.ws.domain.redis.entity.MessageR;
import com.anirbandc.ws.domain.redis.repo.MessageRRepo;
import com.anirbandc.ws.dto.MessageDTO;

@RunWith(SpringRunner.class)
public class MessageDomainImplTest {
	@TestConfiguration
	static class MessageDomainImplTestContextConfiguration {
		@Bean
		public MessageDomain messageDomain() {
			return new MessageDomainImpl();
		}
	}

	@Autowired
	private MessageDomain messageDomain;

	@MockBean
	private MessageRepo messageRepo;
	
	@MockBean
	private MessageRRepo messageRRepo;

	private List<Message> messages;

	@Before
	public void setUp() throws Exception {
		Message message = new Message("Test message");

		message.setId("1234");

		messages = new ArrayList<>(2);

		messages.add(message);

		Mockito.when(messageRepo.save(any(Message.class))).thenReturn(message);

		Mockito.when(messageRepo.findAll()).thenReturn(messages);
	}

	@Test
	public void addMessage_success() {
		MessageDTO messageDTO = new MessageDTO();

		messageDTO.setMessage("Test message");

		messageDomain.addMessageToRedis(messageDTO);

		verify(messageRepo, never()).save(any(Message.class));
		verify(messageRRepo, times(1)).addMessage(any(MessageR.class));
	}
	
	@Test
	public void addMessageToMongoDB_success() {
		Object message = new String("\"{\\\"message\\\":\\\"test\\\"}\"");
		
		messageDomain.addMessageToMongoDB(message);
		
		verify(messageRepo, times(1)).save(any(Message.class));
	}

	@Test
	public void getAllMessage_success() {
		Object messages = messageDomain.getAllMessage();

		verify(messageRepo, times(1)).findAll();

		assertNotNull(messages);
	}

	@Test
	public void getAllMessage_success_nullResult() {
		when(messageRepo.findAll()).thenReturn(null);

		Object messages = messageDomain.getAllMessage();

		verify(messageRepo, times(1)).findAll();

		assertNull(messages);
	}

	@Test
	public void getAllMessage_success_emptyResult() {
		when(messageRepo.findAll()).thenReturn(new ArrayList<>());

		Object messages = messageDomain.getAllMessage();

		verify(messageRepo, times(1)).findAll();

		assertNull(messages);
	}
}
