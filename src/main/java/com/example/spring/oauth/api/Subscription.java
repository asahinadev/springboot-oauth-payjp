package com.example.spring.oauth.api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.spring.oauth.api.parameterized.ListType;
import com.example.spring.oauth.api.parameterized.SingleType;
import com.example.spring.oauth.api.values.Status;
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
 * 定期購買情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Subscription {

	public static final SingleType<Subscription> TYPE = new SingleType<>();
	public static final ListType<Subscription> LIST = new ListType<>();

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

	/** 定期課金開始時。 */
	@JsonProperty("start")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime start;

	/** 顧客。 */
	@JsonProperty("customer")
	String customer;

	/** プラン。 */
	@JsonProperty("plan")
	Plan plan;

	/** プラン（次回）。 */
	@JsonProperty("next_cycle_plan")
	Plan nextCyclePlan;

	/** ステータス。 */
	@JsonProperty("status")
	Status status;

	/** 日割り課金。 */
	@JsonProperty("prorate")
	boolean prorate;

	/** 購読期間開始時。 */
	@JsonProperty("current_period_start")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime currentPeriodStart;

	/** 購読期間終了時。 */
	@JsonProperty("current_period_end")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime currentPeriodEnd;

	/** トライアル期間開始時。 */
	@JsonProperty("trial_start")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime trialStart;

	/** トライアル期間終了時。 */
	@JsonProperty("trial_end")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime trialEmd;

	/** 定期課金解約時。 */
	@JsonProperty("canceled_at")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime canceledAt;

	/** 定期課金停止時。 */
	@JsonProperty("resumed_at")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime resumedAt;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** 追加データ。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
