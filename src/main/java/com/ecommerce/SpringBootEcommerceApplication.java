package com.ecommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootEcommerceApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootEcommerceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEcommerceApplication.class, args);
		logger.info("Spring Boot E-commerce Application has started successfully!");
	}
}
