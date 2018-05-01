/**
 * 
 */
package com.anirbandc.ws.web.api;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.anirbandc.ws.dto.MessageDTO;
import com.anirbandc.ws.exception.handler.AppExceptionHandler;
import com.anirbandc.ws.mock.MockMvcUtil;
import com.anirbandc.ws.mock.TestConstant;
import com.anirbandc.ws.service.MessageService;
import com.anirbandc.ws.web.api.MessageController;
import com.anirbandc.ws.web.message.GenericSuccessResponse;
import com.anirbandc.ws.web.message.response.MessageListResponse;

@RunWith(SpringRunner.class)
public class MessageControllerTest {
	private MockMvc mockMvc;

	@MockBean
	private MessageService messageService;

	@MockBean
	private SimpMessageSendingOperations messagingTemplate;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	private MessageController messageController;

	@Before
	public void setUp() throws Exception {
		this.messageController = new MessageController(messageService, messagingTemplate);

		AppExceptionHandler appExceptionHandler = new AppExceptionHandler();

		this.mockMvc = MockMvcBuilders.standaloneSetup(messageController).setControllerAdvice(appExceptionHandler)
				.build();

		MessageDTO messageDTO = new MessageDTO("Test message");

		List<MessageDTO> messageDTOs = new ArrayList<>(2);

		messageDTOs.add(messageDTO);

		Mockito.when(messageService.processAndAddMessage(any(MessageDTO.class)))
				.thenReturn(new GenericSuccessResponse("Message added"));

		Mockito.when(messageService.processAndGetMessages())
				.thenReturn(new MessageListResponse("Messages found", messageDTOs));
	}

	@Test
	public void addMessage_success() throws Exception {
		MessageDTO messageDTO = new MessageDTO("Test message");

		MockMvcUtil.performMockApiCall(mockMvc, TestConstant.HTTP_POST, "/message", null, null, null, messageDTO, true);
	}

	@Test
	public void addMessage_failure() throws Exception {
		MessageDTO messageDTO = new MessageDTO("");

		MockMvcUtil.performMockApiCall(mockMvc, TestConstant.HTTP_POST, "/message", null, null, null, messageDTO,
				false);
	}

	@Test
	public void getMessages_success() throws Exception {
		MockMvcUtil.performMockApiCall(mockMvc, TestConstant.HTTP_GET, "/message", null, null, null, null, true);
	}
}
