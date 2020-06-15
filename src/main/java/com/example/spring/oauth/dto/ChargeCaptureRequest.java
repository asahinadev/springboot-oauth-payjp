package com.example.spring.oauth.dto;

import com.example.spring.oauth.validator.constraints.Amount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargeCaptureRequest extends Entity {

	/**
	 * �ԋ��z
	 */
	@Amount
	Long amount;

}
