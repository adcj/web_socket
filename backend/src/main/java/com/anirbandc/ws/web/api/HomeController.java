/**
 * 
 */
package com.anirbandc.ws.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anirbandc.ws.util.AppConstant;

/**
 * (REST) Controller that overrides the root path behavior. Displays a custom
 * project specific message.
 * 
 * @author Anirban DC
 */
@RestController
@RequestMapping(value = "/")
public class HomeController {
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> index() {
		return ResponseEntity.ok(AppConstant.HOME_CONTROLLER_GREETING);
	}
}
