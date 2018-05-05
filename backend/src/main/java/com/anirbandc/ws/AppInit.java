package com.anirbandc.ws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.anirbandc.ws.util.AppConstant;

/**
 * This class is responsible for initializing required variables and performing
 * other necessary activities, once application (and hence all associated
 * components) are initialized.
 * 
 * This will happen once after Spring Boot application is initialized.
 * 
 * @author Anirban DC
 */
@Component
public class AppInit implements ApplicationListener<ApplicationReadyEvent> {
	@Value("${application.name}")
	private String applicationName;

	@Value("${build.version}")
	private String buildVersion;

	@Value("${runtime.environment}")
	private String runtimeEnvironment;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		AppConstant.setHttpStatusCode();
	}
}
