package com.example.spring.oauth.api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
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
 * テナント情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Tenant {

	public static final SingleType<Tenant> TYPE = new SingleType<>();
	public static final ListType<Tenant> LIST = new ListType<>();

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

	/** プラットフォーム利用料率。 */
	@JsonProperty("platform_fee_rate")
	String platformFeeRate;

	/** 最低入金額。 */
	@JsonProperty("minimum_transfer_amount")
	long minimumTransferAmount;

	/** 銀行コード。 */
	@JsonProperty("bank_code")
	String bankCode;

	/** 銀行コード。 */
	@JsonProperty("bank_branch_code")
	String bankBranchCode;

	/** 預金種別。 */
	@JsonProperty("bank_account_type")
	String bankAccountType;

	/** 口座番号。 */
	@JsonProperty("bank_account_number")
	String bankAccountNumber;

	/** 口座番号。 */
	@JsonProperty("bank_account_holder_name")
	String bankAccountHolderName;

	/** TODO 口座状態。 */
//	口座状態。pending:未確認, success:入金確認済み, failed:入金不可能
	@JsonProperty("bank_account_status")
	String bankAccountStatus;

	/** 3文字のISOコード。 */
	@JsonProperty("currencies_supported")
	List<Currency> currenciesSupported;//

	/** 通貨コード。 */
	@JsonProperty("default_currency")
	Currency defaultCurrency;

	/** TODO 申請情報を提出済のブランドの各種情報。 */
	@JsonProperty("reviewed_brands")
	List<Map<String, String>> reviewedBrands;//

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** その他情報。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
