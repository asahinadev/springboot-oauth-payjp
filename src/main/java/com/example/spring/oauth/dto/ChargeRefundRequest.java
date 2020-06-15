package com.example.spring.oauth.dto;

import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargeRefundRequest extends Entity {

	/**
	 * •Ô‹àŠz
	 */
	@Positive
	Long amount;

	/**
	 * •Ô‹à——R.
	 */
	String refundReason;
}
