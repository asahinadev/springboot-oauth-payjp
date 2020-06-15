package com.example.spring.oauth.controller;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.spring.oauth.api.Card;
import com.example.spring.oauth.api.DataList;
import com.example.spring.oauth.api.User;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
@RequestMapping("/")
public class IndexController {

	final WebClient webClient;

	@Autowired
	public IndexController(WebClient webClient) {
		this.webClient = webClient;
	}

	@GetMapping
	@ResponseBody
	public User index(@AuthenticationPrincipal User user) {
		log.debug("{}", user);
		return user;
	}

	@GetMapping("cards")
	@ResponseBody
	public Mono<DataList<Card>> cards(@AuthenticationPrincipal User user,
			@RegisteredOAuth2AuthorizedClient("payjp") OAuth2AuthorizedClient client) {

		return webClient.get().uri(b -> b.path("/cards").build())
				.attributes(attributes(client)).retrieve().bodyToMono(
						new ParameterizedTypeReference<DataList<Card>>() {
						});
	}

	@GetMapping("cards/{id}")
	@ResponseBody
	public Mono<Card> cards(@AuthenticationPrincipal User user,
			@RegisteredOAuth2AuthorizedClient("payjp") OAuth2AuthorizedClient client,
			@PathVariable("id") String id) {

		return webClient.get().uri(b -> b.path("/cards/{id}").build(id))
				.attributes(attributes(client)).retrieve().bodyToMono(Card.class);
	}

	Consumer<Map<String, Object>> attributes(OAuth2AuthorizedClient client) {
		return ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient(client);
	}

}
