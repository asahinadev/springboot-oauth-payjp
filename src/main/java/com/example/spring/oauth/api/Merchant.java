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
 * �Ǝҏ��B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Merchant {

	public static final SingleType<Merchant> TYPE = new SingleType<>();
	public static final ListType<Merchant> LIST = new ListType<>();

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

	/** �������s������񂪐ݒ�ρB */
	@JsonProperty("bank_enabled")
	boolean bankEnabled;

	/** �{�Ԋ��ŗ��p�\�ȃJ�[�h�u�����h�̃��X�g�B */
	@JsonProperty("brands_accepted")
	List<String> brandsAccepted;

	/** 3������ISO�R�[�h�B */
	@JsonProperty("default_currency")
	Currency defaultCurrency;

	/** 3������ISO�R�[�h�B */
	@JsonProperty("currencies_supported")
	List<Currency> currenciesSupported;

	/** �{�Ԋ��\����񂪒�o�ς݂��ǂ����B */
	@JsonProperty("details_submitted")
	boolean detailsSubmitted;

	/** �Ɩ��`�ԁB */
	@JsonProperty("business_type")
	String businessType;

	/** ���ݍ��B */
	@JsonProperty("country")
	Country country;

	/** �{�Ԋ��ŗ��p�\�ȃJ�[�h�u�����h�̃��X�g�B */
	@JsonProperty("charge_type")
	List<String> chargeTypes;

	/** �̔����i���B */
	@JsonProperty("product_name")
	String productName;

	/** �̔����i�̎�ރ��X�g�B */
	@JsonProperty("product_type")
	List<String> productType;

	/** �쐬�����B */
	@JsonProperty("livemode_activated_at")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime livemodeActivatedAt;

	/** �\���Ώۂ̃T�C�g���I�[�v���ς݂��ǂ����B */
	@JsonProperty("site_published")
	boolean sitePublished;

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** ���̑����B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
