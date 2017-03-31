package com.univision.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Alejandro
 * 
 *         Main Method to start the whole Spring app
 */
@EnableAutoConfiguration
@ComponentScan // Tell to spring to scan our packages for controllers
public class AppConfig {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}
}
