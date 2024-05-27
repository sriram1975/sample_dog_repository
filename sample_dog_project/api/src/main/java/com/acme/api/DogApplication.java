package com.acme.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DogApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogApplication.class, args);
	}

}
