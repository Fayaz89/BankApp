package com.pack.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication
public class CardMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardMicroserviceApplication.class, args);
	}

}
