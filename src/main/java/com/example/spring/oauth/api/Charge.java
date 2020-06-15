package com.example.spring.oauth.api;

import java.time.LocalDateTime;
import java.util.HashMap;
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
 * �x�����B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Charge {

	public static final SingleType<Charge> TYPE = new SingleType<>();
	public static final ListType<Charge> LIST = new ListType<>();

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

	/** �X�V�����B */
	@JsonProperty("updated")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime updated;

	/** �x���z�B */
	@JsonProperty("amount")
	long amount;

	/** �ʉ݃R�[�h�B */
	@JsonProperty("currency")
	Currency currency;

	/** ���ϔF�؂̉ہB */
	@JsonProperty("paid")
	boolean paid;

	/** ���ϔF�؂̗L�������B */
	@JsonProperty("expired_at")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime expiredAt;

	/** �x�����������m�肵�Ă��邩�ǂ����B */
	@JsonProperty("captured")
	boolean captured;

	/** �x���������m������B */
	@JsonProperty("captured_at")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime capturedAt;

	/** �N���W�b�g�J�[�h�B */
	@JsonProperty("card")
	Card card;

	/** �ڋq��\����ӂ̃L�[�B */
	@JsonProperty("customer")
	String customer;

	/** �T�v�B */
	@JsonProperty("description")
	String description;

	/** �x�����̎��s���R�B */
	@JsonProperty("failure_code")
	String failureCode;

	/** �x�����̎��s�T�v�B */
	@JsonProperty("failure_message")
	String failureMessage;

	/** �ԋ��ς݁B */
	@JsonProperty("refunded")
	boolean refunded;

	/** �ԋ��z�B */
	@JsonProperty("amount_refunded")
	long amountRefunded;

	/** �ԋ����R�B */
	@JsonProperty("refund_reason")
	String amountReason;

	/** ����w���B */
	@JsonProperty("subscription")
	String subscription;

	/** �����z�B */
	@JsonProperty("platform_fee")
	long platformFee;

	/** �e�i���g�B */
	@JsonProperty("tenant")
	String tenant;

	/** �v���b�g�t�H�[�����p���B */
	@JsonProperty("platform_fee_rate")
	String platformFeeRate;

	/** �v���b�g�t�H�[�����p�z�B */
	@JsonProperty("total_platform_fee")
	long totalPlatformFee;

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** ���̑����B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
