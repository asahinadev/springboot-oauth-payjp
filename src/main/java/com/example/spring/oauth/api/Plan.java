package com.example.spring.oauth.api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.spring.oauth.api.parameterized.ListType;
import com.example.spring.oauth.api.parameterized.SingleType;
import com.example.spring.oauth.api.values.Currency;
import com.example.spring.oauth.api.values.Interval;
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
 * プラン情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Plan {

	public static final SingleType<Plan> TYPE = new SingleType<>();
	public static final ListType<Plan> LIST = new ListType<>();

	/** 識別子。 */
	@JsonProperty("id")
	String id;

	/** 本番判定。 */
	@JsonProperty("livemode")
	boolean livemode;

	/** オブジェクトタイプ。 */
	@JsonProperty("object")
	String object;

	/** 作成日時。 */
	@JsonProperty("created")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime created;

	/** プラン名。 */
	@JsonProperty("name")
	String name;

	/** 通貨。 */
	@JsonProperty("currency ")
	Currency currency;

	/** 支払金額。 */
	@JsonProperty("amount")
	long amount;

	/** 支払い間隔。 */
	@JsonProperty("interval")
	Interval interval;

	/** トライアル（日）。 */
	@JsonProperty("trial_days ")
	int trial;

	/** 支払い日。 */
	@JsonProperty("billing_day")
	int billing;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** 追加データ。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();

}
