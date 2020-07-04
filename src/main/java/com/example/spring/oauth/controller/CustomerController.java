package com.example.spring.oauth.controller;

import javax.validation.Valid;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.oauth.api.Customer;
import com.example.spring.oauth.api.DataList;
import com.example.spring.oauth.dto.CustomerRequest;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseController {

	@GetMapping
	public Mono<DataList<Customer>> index(@RequestParam MultiValueMap<String, String> query) {
		log.debug("request => {}", query);
		return getServer(Customer.LIST, "/customers");
	}

	@PostMapping
	public Mono<Customer> create(@Valid @RequestBody CustomerRequest requestBody) {
		log.debug("request => {}", requestBody);
		return postServer(Customer.TYPE, requestBody, CustomerRequest.class, "/customers");
	}

	@GetMapping("{id}")
	public Mono<Customer> get(@PathVariable("id") String id) {
		log.debug("request => {}", id);
		return getServer(Customer.TYPE, "/customers/{id}", id);
	}

	@PostMapping("{id}")
	public Mono<Customer> update(@PathVariable("id") String id, @Valid @RequestBody CustomerRequest requestBody) {
		log.debug("request => {}", id);
		return postServer(Customer.TYPE, requestBody, CustomerRequest.class, "/customers/{id}", id);
	}

	@DeleteMapping("{id}")
	public Mono<Customer> delete(@PathVariable("id") String id) {
		log.debug("request => {}", id);
		return deleteServer(Customer.TYPE, "/customers/{id}", id);
	}

}
