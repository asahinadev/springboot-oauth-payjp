package com.example.spring.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.oauth.api.Card;
import com.example.spring.oauth.api.DataList;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/cards")
public class CardController extends BaseController {

	@GetMapping
	public Mono<DataList<Card>> index() {
		log.debug("id => {}", "");
		return getServer(Card.LIST, "/cards");
	}

	@GetMapping("{id}")
	public Mono<Card> get(@PathVariable("id") String id) {
		log.debug("id => {}", id);
		return getServer(Card.TYPE, "/cards/{id}", id);
	}

}
