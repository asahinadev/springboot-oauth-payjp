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
 * �A�J�E���g���B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Account {

	public static final SingleType<Account> TYPE = new SingleType<>();
	public static final ListType<Account> LIST = new ListType<>();

	/** ���ʎq�B */
	@JsonProperty("id")
	String id;

	/** �{�Ԕ���B */
	@JsonProperty("livemode")
	boolean livemode;

	/** �I�u�W�F�N�g�^�C�v�B */
	@JsonProperty("object")
	String object;

	/** ���[���A�h���X�B */
	@JsonProperty("email")
	String email;

	/** �쐬�����B */
	@JsonProperty("created")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime created;

	/** ������B */
	@JsonProperty("merchant")
	Merchant merchant;

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** �ǉ��f�[�^�B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}