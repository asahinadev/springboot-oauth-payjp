package com.example.spring.oauth.controller;

import javax.validation.Valid;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.oauth.api.Charge;
import com.example.spring.oauth.api.DataList;
import com.example.spring.oauth.dto.ChargeCapture;
import com.example.spring.oauth.dto.ChargeReauth;
import com.example.spring.oauth.dto.ChargeRefund;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/charges")
public class ChargeController extends BaseController {

	@GetMapping
	public Mono<DataList<Charge>> index(@RequestParam MultiValueMap<String, String> query) {
		log.debug("request => {}", query);
		return getServer(Charge.LIST, "/charges");
	}

	@PostMapping
	public Mono<Charge> create(@Valid @RequestBody Charge charge) {
		log.debug("request => {}", charge);
		return postServer(Charge.TYPE, charge, Charge.class, "/charges");
	}

	@GetMapping("{id}")
	public Mono<Charge> get(@PathVariable("id") String id) {
		log.debug("request => {}", id);
		return getServer(Charge.TYPE, "/charges/{id}", id);
	}

	@PostMapping("{id}")
	public Mono<Charge> update(@PathVariable("id") String id, @Valid @RequestBody Charge charge) {
		log.debug("request => {}", id);
		return postServer(Charge.TYPE, charge, Charge.class, "/charges/{id}", id);
	}

	@PostMapping("{id}/reauth")
	public Mono<Charge> reauth(@PathVariable("id") String id, @Valid @RequestBody ChargeReauth reauth) {
		log.debug("request => {}", id);
		return postServer(Charge.TYPE, reauth, ChargeReauth.class, "/charges/{id}/reauth", id);
	}

	@PostMapping("{id}/refund")
	public Mono<Charge> refund(@PathVariable("id") String id, @Valid @RequestBody ChargeRefund refund) {
		log.debug("request => {}", id);
		return postServer(Charge.TYPE, refund, ChargeRefund.class, "/charges/{id}/refund", id);
	}

	@PostMapping("{id}/capture")
	public Mono<Charge> capture(@PathVariable("id") String id, @Valid @RequestBody ChargeCapture capture) {
		log.debug("request => {}", id);
		return postServer(Charge.TYPE, capture, ChargeCapture.class, "/charges/{id}/capture", id);
	}

}
