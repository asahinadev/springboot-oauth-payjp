package com.example.spring.oauth.api;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * トークン情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Summary {

	/** 支払い総回数。 */
	@JsonProperty("charge_count")
	long chargeCount;

	/** 支払い手数料。 */
	@JsonProperty("charge_fee")
	long chargeFee;

	/** 総売上。 */
	@JsonProperty("charge_gross")
	long chargeGross;

	/** 差引額。 */
	@JsonProperty("net")
	long net;

	/** 返金総額。 */
	@JsonProperty("refund_amount")
	long refundAmount;

	/** 返金総数。 */
	@JsonProperty("refund_count")
	long refundCount;

	/** プラットフォーム手数料総額を表します。 */
	@JsonProperty("total_platform_fee")
	long totalPlatformFee;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** 追加データ。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
