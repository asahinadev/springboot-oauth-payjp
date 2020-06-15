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
	 * 支払金額
	 */
	@Amount
	Long amount;

	/**
	 * 通貨.
	 */
	@Pattern(regexp = "^JPY$")
	String currency;

	/**
	 * 商品.
	 */
	String product;

	/**
	 * 顧客.
	 */
	String customer;

	/**
	 * カード番号（token).
	 */
	String card;

	/**
	 * 概要.
	 */
	String description;

	/**
	 * 支払いの確定.
	 */
	boolean capture;

	/**
	 * 認証が失効するまでの日数.
	 */
	@JsonProperty("expiry_days ")
	@Positive
	long expiryDays;

	/**
	 * メタデータ.
	 */
	Map<String, Object> metadata;

	/**
	 * プラットフォーム利用料.
	 */
	@JsonProperty("platform_fee")
	long platformFee;

	/**
	 * テナント.
	 */
	String tenant;

	@AssertTrue
	public boolean valid() {
		return StringUtils.isAnyEmpty(currency, product)
				&& StringUtils.isAnyEmpty(card, customer);
	}
}
