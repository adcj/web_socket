/**
 * 
 */
package com.anirbandc.ws.web.api;

import javax.validation.Valid;

import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anirbandc.ws.dto.MessageDTO;
import com.anirbandc.ws.service.MessageService;
import com.anirbandc.ws.util.AppConstant;
import com.anirbandc.ws.util.AppLog;
import com.anirbandc.ws.util.AppUtil;
import com.anirbandc.ws.web.message.AbstractResponse;
import com.anirbandc.ws.web.message.GenericSuccessResponse;
import com.anirbandc.ws.web.message.response.MessageListResponse;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
	private final AppLog appLog;

	private final MessageService messageService;
	private final SimpMessageSendingOperations messagingTemplate;

	@Autowired
	public MessageController(final MessageService messageService,
			final SimpMessageSendingOperations messagingTemplate) {
		this.appLog = new AppLog(getClass());

		this.messageService = messageService;
		this.messagingTemplate = messagingTemplate;
	}

	/**
	 * Accept add message request and return appropriate response once done
	 * 
	 * @param messageDTO
	 * @return {@link AbstractResponse}: instance of
	 *         {@link GenericSuccessResponse}
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<AbstractResponse> addMessage(@Valid @RequestBody final MessageDTO messageDTO) {
		String methodName = "addMessage";

		AbstractResponse addMessageResponse = messageService.processAndAddMessage(messageDTO);

		messagingTemplate.convertAndSend(AppConstant.EP_MESSAGE_BROKER, messageDTO.getMessage());

		appLog.printLog(Level.INFO, methodName, AppUtil.convertObjectToJson(addMessageResponse));

		return ResponseEntity.status(HttpStatus.OK).body(addMessageResponse);
	}

	/**
	 * Accept get message request and return appropriate response once done
	 * 
	 * @return {@link AbstractResponse}: instance of {@link MessageListResponse}
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<AbstractResponse> getMessages() {
		String methodName = "getMessages";

		AbstractResponse getMessageResponse = messageService.processAndGetMessages();

		appLog.printLog(Level.INFO, methodName, AppUtil.convertObjectToJson(getMessageResponse));

		return ResponseEntity.status(HttpStatus.OK).body(getMessageResponse);
	}
}
