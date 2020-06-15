package com.example.spring.oauth.dto;

import java.util.Map;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.apache.commons.lang3.StringUtils;

import com.example.spring.oauth.validator.constraints.Amount;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargeRequest extends Entity {

	/**
	 * �x�����z
	 */
	@Amount
	Long amount;

	/**
	 * �ʉ�.
	 */
	@Pattern(regexp = "^JPY$")
	String currency;

	/**
	 * ���i.
	 */
	String product;

	/**
	 * �ڋq.
	 */
	String customer;

	/**
	 * �J�[�h�ԍ��itoken).
	 */
	String card;

	/**
	 * �T�v.
	 */
	String description;

	/**
	 * �x�����̊m��.
	 */
	boolean capture;

	/**
	 * �F�؂���������܂ł̓���.
	 */
	@JsonProperty("expiry_days ")
	@Positive
	long expiryDays;

	/**
	 * ���^�f�[�^.
	 */
	Map<String, Object> metadata;

	/**
	 * �v���b�g�t�H�[�����p��.
	 */
	@JsonProperty("platform_fee")
	long platformFee;

	/**
	 * �e�i���g.
	 */
	String tenant;

	@AssertTrue
	public boolean valid() {
		return StringUtils.isAnyEmpty(currency, product)
				&& StringUtils.isAnyEmpty(card, customer);
	}
}
