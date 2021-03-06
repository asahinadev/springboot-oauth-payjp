package com.example.spring.oauth.dto;

import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargeRefundRequest extends Entity {

	/**
	 * 返金額
	 */
	@Positive
	Long amount;

	/**
	 * 返金理由.
	 */
	String refundReason;
}
