package com.practica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class Jwt22Application {

	public static void main(String[] args) {
		SpringApplication.run(Jwt22Application.class, args);
	}

}
