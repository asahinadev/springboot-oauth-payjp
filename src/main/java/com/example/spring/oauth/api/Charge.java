package com.example.spring.oauth.api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.spring.oauth.api.parameterized.ListType;
import com.example.spring.oauth.api.parameterized.SingleType;
import com.example.spring.oauth.api.values.Currency;
import com.example.spring.oauth.serializer.UnixTimeDeserializer;
import com.example.spring.oauth.serializer.UnixTimeSerializer;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * 支払情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Charge {

	public static final SingleType<Charge> TYPE = new SingleType<>();
	public static final ListType<Charge> LIST = new ListType<>();

	/** 識別子。 */
	@JsonProperty("id")
	String id;

	/** 本番判定。 */
	@JsonProperty("livemode")
	boolean livemode;

	/** 作成日時。 */
	@JsonProperty("created")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime created;

	/** 更新日時。 */
	@JsonProperty("updated")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime updated;

	/** 支払額。 */
	@JsonProperty("amount")
	long amount;

	/** 通貨コード。 */
	@JsonProperty("currency")
	Currency currency;

	/** 決済認証の可否。 */
	@JsonProperty("paid")
	boolean paid;

	/** 決済認証の有効期限。 */
	@JsonProperty("expired_at")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime expiredAt;

	/** 支払い処理を確定しているかどうか。 */
	@JsonProperty("captured")
	boolean captured;

	/** 支払い処理確定日時。 */
	@JsonProperty("captured_at")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime capturedAt;

	/** クレジットカード。 */
	@JsonProperty("card")
	Card card;

	/** 顧客を表す一意のキー。 */
	@JsonProperty("customer")
	String customer;

	/** 概要。 */
	@JsonProperty("description")
	String description;

	/** 支払いの失敗理由。 */
	@JsonProperty("failure_code")
	String failureCode;

	/** 支払いの失敗概要。 */
	@JsonProperty("failure_message")
	String failureMessage;

	/** 返金済み。 */
	@JsonProperty("refunded")
	boolean refunded;

	/** 返金額。 */
	@JsonProperty("amount_refunded")
	long amountRefunded;

	/** 返金理由。 */
	@JsonProperty("refund_reason")
	String amountReason;

	/** 定期購入。 */
	@JsonProperty("subscription")
	String subscription;

	/** 入金額。 */
	@JsonProperty("platform_fee")
	long platformFee;

	/** テナント。 */
	@JsonProperty("tenant")
	String tenant;

	/** プラットフォーム利用率。 */
	@JsonProperty("platform_fee_rate")
	String platformFeeRate;

	/** プラットフォーム利用額。 */
	@JsonProperty("total_platform_fee")
	long totalPlatformFee;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** その他情報。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
