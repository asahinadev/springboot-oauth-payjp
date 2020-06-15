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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * 商品情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Product {

	public static final SingleType<Product> TYPE = new SingleType<>();
	public static final ListType<Product> LIST = new ListType<>();

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

	/** 支払い処理を確定するか。 */
	@JsonProperty("capture")
	boolean capture;

	/** 有効日時。 */
	@JsonProperty("invalid_after")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime invalidAfter;

	/** QRコード URL。 */
	@JsonProperty("paycode_url")
	String paycodeUrl;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** その他情報。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
