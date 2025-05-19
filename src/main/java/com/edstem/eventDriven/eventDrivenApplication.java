package com.edstem.eventDriven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class eventDrivenApplication {
	public static void main(String[] args) {
		SpringApplication.run(eventDrivenApplication.class, args);
	}
}
