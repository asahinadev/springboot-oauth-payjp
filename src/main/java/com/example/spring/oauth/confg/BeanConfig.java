package com.example.spring.oauth.confg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfig {

	@Autowired
	PayjpApiConfig config;

	@Autowired
	ReactiveClientRegistrationRepository client;

	@Autowired
	ServerOAuth2AuthorizedClientRepository auth;

	@Bean
	public WebClient adminClient() {
		return WebClient.builder()
				.baseUrl(config.getBaseurl())
				.filter(oauth2ExchangeFilterFunction())
				.build();
	}

	@Bean
	public WebClient serverClient() {
		return WebClient.builder()
				.baseUrl(config.getBaseurl())
				.defaultHeader("Authorization", "Basic " + config.getPrivateKey() + ":")
				.filter(oauth2ExchangeFilterFunction())
				.build();
	}

	private ExchangeFilterFunction oauth2ExchangeFilterFunction() {
		return new ServerOAuth2AuthorizedClientExchangeFilterFunction(client, auth);
	}
}
