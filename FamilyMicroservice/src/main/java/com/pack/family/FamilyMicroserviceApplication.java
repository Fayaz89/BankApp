package com.pack.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication
public class FamilyMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyMicroserviceApplication.class, args);
	}

}
