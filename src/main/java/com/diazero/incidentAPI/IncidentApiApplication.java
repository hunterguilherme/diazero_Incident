package com.diazero.incidentAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.diazero.incidentAPI.controller",
		"com.diazero.incidentAPI.domain.service",
		"com.diazero.incidentAPI.domain.repository",
		"com.diazero.incidentAPI.domain.exceptions",
		"com.diazero.incidentAPI.ExceptionHandler",
		"com.diazero.incidentAPI"})
public class IncidentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncidentApiApplication.class, args);
	}

}
