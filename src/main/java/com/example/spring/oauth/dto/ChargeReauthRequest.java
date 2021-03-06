package com.example.spring.oauth.dto;

import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargeReauthRequest extends Entity {

	/**
	 * 認証が失効するまでの日数.
	 */
	@JsonProperty("expiry_days ")
	@Positive
	long expiryDays;
}
