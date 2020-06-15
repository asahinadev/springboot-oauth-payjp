package com.example.spring.oauth.api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.spring.oauth.api.parameterized.ListType;
import com.example.spring.oauth.api.parameterized.SingleType;
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
 * �ڋq���B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Customer {

	public static final SingleType<Customer> TYPE = new SingleType<>();
	public static final ListType<Customer> LIST = new ListType<>();

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

	/** �ڋq�A����imail)�B */
	@JsonProperty("email")
	String email;

	/** �T�v�B */
	@JsonProperty("description")
	String description;

	/** �����ݒ�J�[�h�B */
	@JsonProperty("default_card")
	String defaultCard;

	/** �o�^�J�[�h���B */
	@JsonProperty("cards")
	DataList<Card> cards;

	/** �o�^����w�����B */
	@JsonProperty("subscriptions")
	DataList<Subscription> subscriptions;

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** ���̑����B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}