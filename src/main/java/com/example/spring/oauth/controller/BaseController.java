package com.example.spring.oauth.controller;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class BaseController {

	@Autowired
	protected WebClient serverClient;

	@Autowired
	protected WebClient adminClient;

	protected final Consumer<Map<String, Object>> attributes(OAuth2AuthorizedClient client) {
		return ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient(client);
	}

	<E> Mono<E> getServer(ParameterizedTypeReference<E> type, String path, Object... values) {
		return serverClient.get().uri(b -> b.path(path).build(values)).retrieve().bodyToMono(type);
	}

	<E, T> Mono<E> postServer(
			ParameterizedTypeReference<E> type, T body, Class<T> clazz, String path, Object... values) {
		return serverClient.post().uri(b -> b.path(path).build(values)).body(body, clazz).retrieve().bodyToMono(type);
	}

	<E, T> Mono<E> deleteServer(ParameterizedTypeReference<E> type, String path, Object... values) {
		return serverClient.delete().uri(b -> b.path(path).build(values)).retrieve().bodyToMono(type);
	}
}
