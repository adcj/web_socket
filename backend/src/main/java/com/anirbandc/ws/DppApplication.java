package com.anirbandc.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.falconio.dpp.domain.mongodb.repo")
@PropertySource("classpath:/application.properties")
public class DppApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DppApplication.class);

		app.run(args);
	}
}
