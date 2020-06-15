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
 * �g�[�N�����B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Summary {

	/** �x�������񐔁B */
	@JsonProperty("charge_count")
	long chargeCount;

	/** �x�����萔���B */
	@JsonProperty("charge_fee")
	long chargeFee;

	/** ������B */
	@JsonProperty("charge_gross")
	long chargeGross;

	/** �����z�B */
	@JsonProperty("net")
	long net;

	/** �ԋ����z�B */
	@JsonProperty("refund_amount")
	long refundAmount;

	/** �ԋ������B */
	@JsonProperty("refund_count")
	long refundCount;

	/** �v���b�g�t�H�[���萔�����z��\���܂��B */
	@JsonProperty("total_platform_fee")
	long totalPlatformFee;

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** �ǉ��f�[�^�B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
