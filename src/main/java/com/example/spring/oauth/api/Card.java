package com.example.spring.oauth.api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.spring.oauth.api.parameterized.ListType;
import com.example.spring.oauth.api.parameterized.SingleType;
import com.example.spring.oauth.api.values.Country;
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
 * カード情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Card {

	public static final SingleType<Card> TYPE = new SingleType<>();
	public static final ListType<Card> LIST = new ListType<>();

	/** オブジェクトタイプ。 */
	@JsonProperty("object")
	String object;

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

	/** 顧客 */
	@JsonProperty("customer")
	String customer;

	/** カード名義。 */
	@JsonProperty("name")
	String name;

	/** カード番号（下四桁）。 */
	@JsonProperty("last4")
	String last4;

	/** 有効期限（月）。 */
	@JsonProperty("exp_month")
	short expMonth;

	/** 有効期限（年）。 */
	@JsonProperty("exp_year")
	short expYear;

	/** カードブランド。 */
	@JsonProperty("brand")
	String brand;

	/** CVCコードチェックの結果。 */
	@JsonProperty("cvc_check")
	String cvcCheck;

	/** このクレジットカード番号に紐づく値。 */
	@JsonProperty("fingerprint")
	String fingerprint;

	/** 住所（国）。 */
	@JsonProperty("country")
	Country country;

	/** 住所（都道府県）。 */
	@JsonProperty("address_state")
	String state;

	/** 住所（市区町村）。 */
	@JsonProperty("address_city")
	String city;

	/** 住所（町域）。 */
	@JsonProperty("address_line1")
	String address1;

	/** 住所（建物等）。 */
	@JsonProperty("address_line2")
	String address2;

	/** 住所（郵便番号）。 */
	@JsonProperty("address_zip")
	String zip;

	/** 住所（郵便番号、判定）。 */
	@JsonProperty("address_zip_check")
	String zipCheck;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** 追加データ。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();

}
