/**
 * 
 */
package com.anirbandc.ws.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
import com.anirbandc.ws.dto.MessageDTO;
import com.anirbandc.ws.service.MessageService;
import com.anirbandc.ws.service.impl.MessageServiceImpl;
import com.anirbandc.ws.web.message.AbstractResponse;
import com.anirbandc.ws.web.message.response.MessageListResponse;

@RunWith(SpringRunner.class)
public class MessageServiceImplTest {
	@TestConfiguration
	static class MessageServiceImplTestContextConfiguration {
		@Bean
		public MessageService messageService() {
			return new MessageServiceImpl();
		}
	}

	@Autowired
	private MessageService messageService;

	@MockBean
	private MessageDomain messageDomain;

	@Before
	public void setUp() throws Exception {
		MessageDTO messageDTO = new MessageDTO("Test message");

		List<MessageDTO> messageDTOs = new ArrayList<>(2);

		messageDTOs.add(messageDTO);

		//Mockito.when(messageDomain.addMessage(any(MessageDTO.class))).thenReturn(messageDTO);

		Mockito.when(messageDomain.getAllMessage()).thenReturn(messageDTOs);
	}

	@Test
	public void processAndAddMessage() {
		MessageDTO messageDTO = new MessageDTO();

		messageDTO.setMessage("Test message");

		AbstractResponse addMessageResponse = messageService.processAndAddMessage(messageDTO);

		//verify(messageDomain, times(1)).addMessage(any(MessageDTO.class));

		assertNotNull(addMessageResponse);
		assertEquals("Message added", addMessageResponse.getStatusMessage());
	}

	@Test
	public void processAndGetMessages_success() {
		MessageListResponse getMessageResponse = (MessageListResponse) messageService.processAndGetMessages();

		verify(messageDomain, times(1)).getAllMessage();

		assertNotNull(getMessageResponse);
		assertEquals("Messages found", getMessageResponse.getStatusMessage());
	}

	@Test
	public void processAndGetMessages_success_noResult() {
		Mockito.when(messageDomain.getAllMessage()).thenReturn(null);

		MessageListResponse getMessageResponse = (MessageListResponse) messageService.processAndGetMessages();

		verify(messageDomain, times(1)).getAllMessage();

		assertNotNull(getMessageResponse);
		assertEquals("No messages found", getMessageResponse.getStatusMessage());
	}
}
