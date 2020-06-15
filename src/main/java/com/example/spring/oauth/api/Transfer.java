package com.example.spring.oauth.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.spring.oauth.api.parameterized.ListType;
import com.example.spring.oauth.api.parameterized.SingleType;
import com.example.spring.oauth.api.values.Currency;
import com.example.spring.oauth.api.values.TransferStatus;
import com.example.spring.oauth.serializer.UnixTimeDeserializer;
import com.example.spring.oauth.serializer.UnixTimeSerializer;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * 入金情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Transfer {

	public static final SingleType<Transfer> TYPE = new SingleType<>();
	public static final ListType<Transfer> LIST = new ListType<>();

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

	/** 支払額。 */
	@JsonProperty("amount")
	long amount;

	/** 通貨コード。 */
	@JsonProperty("currency")
	Currency currency;

	/** この入金の処理状態を表す値。 */
	@JsonProperty("status")
	TransferStatus status;

	/** 通貨コード。 */
	@JsonProperty("charges")
	List<Charge> charges;

	/** 入金予定日。 */
	@JsonProperty("scheduled_date")
	LocalDate scheduledDate;

	/** この入金に関する集計情報。 */
	@JsonProperty("summary")
	Summary summary;

	/** 概要。 */
	@JsonProperty("description")
	String description;

	/** 作成日時。 */
	@JsonProperty("term_start")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime termStart;

	/** 作成日時。 */
	@JsonProperty("term_end")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime termEnd;

	/** 入金額。 */
	@JsonProperty("transfer_amount")
	long transferAmount;

	/** 入金日。 */
	@JsonProperty("transfer_date")
	LocalDate transferDate;

	/** 繰越金。 */
	@JsonProperty("carried_balance")
	long carriedBalance;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** 追加データ。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
