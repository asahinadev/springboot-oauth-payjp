package com.example.spring.oauth.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.spring.oauth.api.parameterized.ListType;
import com.example.spring.oauth.api.parameterized.SingleType;
import com.example.spring.oauth.api.values.Currency;
import com.example.spring.oauth.api.values.TransferStatus;
import com.example.spring.oauth.serializer.UnixTimeDeserializer;
import com.example.spring.oauth.serializer.UnixTimeSerializer;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * �������B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Transfer {

	public static final SingleType<Transfer> TYPE = new SingleType<>();
	public static final ListType<Transfer> LIST = new ListType<>();

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

	/** �x���z�B */
	@JsonProperty("amount")
	long amount;

	/** �ʉ݃R�[�h�B */
	@JsonProperty("currency")
	Currency currency;

	/** ���̓����̏�����Ԃ�\���l�B */
	@JsonProperty("status")
	TransferStatus status;

	/** �ʉ݃R�[�h�B */
	@JsonProperty("charges")
	List<Charge> charges;

	/** �����\����B */
	@JsonProperty("scheduled_date")
	LocalDate scheduledDate;

	/** ���̓����Ɋւ���W�v���B */
	@JsonProperty("summary")
	Summary summary;

	/** �T�v�B */
	@JsonProperty("description")
	String description;

	/** �쐬�����B */
	@JsonProperty("term_start")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime termStart;

	/** �쐬�����B */
	@JsonProperty("term_end")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime termEnd;

	/** �����z�B */
	@JsonProperty("transfer_amount")
	long transferAmount;

	/** �������B */
	@JsonProperty("transfer_date")
	LocalDate transferDate;

	/** �J�z���B */
	@JsonProperty("carried_balance")
	long carriedBalance;

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** �ǉ��f�[�^�B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
