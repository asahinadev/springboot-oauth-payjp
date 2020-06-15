package com.example.spring.oauth.dto;

import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargeRefundRequest extends Entity {

	/**
	 * �ԋ��z
	 */
	@Positive
	Long amount;

	/**
	 * �ԋ����R.
	 */
	String refundReason;
}
