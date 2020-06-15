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
 * �J�[�h���B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Card {

	public static final SingleType<Card> TYPE = new SingleType<>();
	public static final ListType<Card> LIST = new ListType<>();

	/** �I�u�W�F�N�g�^�C�v�B */
	@JsonProperty("object")
	String object;

	/** ���ʎq�B */
	@JsonProperty("id")
	String id;

	/** �{�Ԕ���B */
	@JsonProperty("livemode")
	boolean livemode;

	/** �쐬�����B */
	@JsonProperty("created")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime created;

	/** �ڋq */
	@JsonProperty("customer")
	String customer;

	/** �J�[�h���`�B */
	@JsonProperty("name")
	String name;

	/** �J�[�h�ԍ��i���l���j�B */
	@JsonProperty("last4")
	String last4;

	/** �L�������i���j�B */
	@JsonProperty("exp_month")
	short expMonth;

	/** �L�������i�N�j�B */
	@JsonProperty("exp_year")
	short expYear;

	/** �J�[�h�u�����h�B */
	@JsonProperty("brand")
	String brand;

	/** CVC�R�[�h�`�F�b�N�̌��ʁB */
	@JsonProperty("cvc_check")
	String cvcCheck;

	/** ���̃N���W�b�g�J�[�h�ԍ��ɕR�Â��l�B */
	@JsonProperty("fingerprint")
	String fingerprint;

	/** �Z���i���j�B */
	@JsonProperty("country")
	Country country;

	/** �Z���i�s���{���j�B */
	@JsonProperty("address_state")
	String state;

	/** �Z���i�s�撬���j�B */
	@JsonProperty("address_city")
	String city;

	/** �Z���i����j�B */
	@JsonProperty("address_line1")
	String address1;

	/** �Z���i�������j�B */
	@JsonProperty("address_line2")
	String address2;

	/** �Z���i�X�֔ԍ��j�B */
	@JsonProperty("address_zip")
	String zip;

	/** �Z���i�X�֔ԍ��A����j�B */
	@JsonProperty("address_zip_check")
	String zipCheck;

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** �ǉ��f�[�^�B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();

}
