package com.example.spring.oauth.dto;

import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargeReauth extends Entity {

	/**
	 * �F�؂���������܂ł̓���.
	 */
	@JsonProperty("expiry_days ")
	@Positive
	long expiryDays;
}
