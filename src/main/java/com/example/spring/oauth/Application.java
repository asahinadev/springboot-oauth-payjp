package com.example.spring.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan(basePackages = "com.example.spring.oauth.config")
@SpringBootApplication(scanBasePackages = "com.example.spring.oauth")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
