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
 * �e�i���g���B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Tenant {

	public static final SingleType<Tenant> TYPE = new SingleType<>();
	public static final ListType<Tenant> LIST = new ListType<>();

	/** ���ʎq�B */
	@JsonProperty("id")
	String id;

	/** �{�Ԕ���B */
	@JsonProperty("livemode")
	boolean livemode;

	/** �I�u�W�F�N�g�^�C�v�B */
	@JsonProperty("object")
	String object;

	/** �쐬�����B */
	@JsonProperty("created")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime created;

	/** �v���b�g�t�H�[�����p�����B */
	@JsonProperty("platform_fee_rate")
	String platformFeeRate;

	/** �Œ�����z�B */
	@JsonProperty("minimum_transfer_amount")
	long minimumTransferAmount;

	/** ��s�R�[�h�B */
	@JsonProperty("bank_code")
	String bankCode;

	/** ��s�R�[�h�B */
	@JsonProperty("bank_branch_code")
	String bankBranchCode;

	/** �a����ʁB */
	@JsonProperty("bank_account_type")
	String bankAccountType;

	/** �����ԍ��B */
	@JsonProperty("bank_account_number")
	String bankAccountNumber;

	/** �����ԍ��B */
	@JsonProperty("bank_account_holder_name")
	String bankAccountHolderName;

	/** TODO ������ԁB */
//	������ԁBpending:���m�F, success:�����m�F�ς�, failed:�����s�\
	@JsonProperty("bank_account_status")
	String bankAccountStatus;

	/** 3������ISO�R�[�h�B */
	@JsonProperty("currencies_supported")
	List<Currency> currenciesSupported;//

	/** �ʉ݃R�[�h�B */
	@JsonProperty("default_currency")
	Currency defaultCurrency;

	/** TODO �\�������o�ς̃u�����h�̊e����B */
	@JsonProperty("reviewed_brands")
	List<Map<String, String>> reviewedBrands;//

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** ���̑����B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
