package com.example.spring.oauth.api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.spring.oauth.api.parameterized.ListType;
import com.example.spring.oauth.api.parameterized.SingleType;
import com.example.spring.oauth.api.values.Country;
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
 * 業者情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Merchant {

	public static final SingleType<Merchant> TYPE = new SingleType<>();
	public static final ListType<Merchant> LIST = new ListType<>();

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

	/** 入金先銀行口座情報が設定済。 */
	@JsonProperty("bank_enabled")
	boolean bankEnabled;

	/** 本番環境で利用可能なカードブランドのリスト。 */
	@JsonProperty("brands_accepted")
	List<String> brandsAccepted;

	/** 3文字のISOコード。 */
	@JsonProperty("default_currency")
	Currency defaultCurrency;

	/** 3文字のISOコード。 */
	@JsonProperty("currencies_supported")
	List<Currency> currenciesSupported;

	/** 本番環境申請情報が提出済みかどうか。 */
	@JsonProperty("details_submitted")
	boolean detailsSubmitted;

	/** 業務形態。 */
	@JsonProperty("business_type")
	String businessType;

	/** 所在国。 */
	@JsonProperty("country")
	Country country;

	/** 本番環境で利用可能なカードブランドのリスト。 */
	@JsonProperty("charge_type")
	List<String> chargeTypes;

	/** 販売商品名。 */
	@JsonProperty("product_name")
	String productName;

	/** 販売商品の種類リスト。 */
	@JsonProperty("product_type")
	List<String> productType;

	/** 作成日時。 */
	@JsonProperty("livemode_activated_at")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime livemodeActivatedAt;

	/** 申請対象のサイトがオープン済みかどうか。 */
	@JsonProperty("site_published")
	boolean sitePublished;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** その他情報。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
