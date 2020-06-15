package com.example.spring.oauth.api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.spring.oauth.api.parameterized.ListType;
import com.example.spring.oauth.api.parameterized.SingleType;
import com.example.spring.oauth.api.values.Status;
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
 * ����w�����B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Subscription {

	public static final SingleType<Subscription> TYPE = new SingleType<>();
	public static final ListType<Subscription> LIST = new ListType<>();

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

	/** ����ۋ��J�n���B */
	@JsonProperty("start")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime start;

	/** �ڋq�B */
	@JsonProperty("customer")
	String customer;

	/** �v�����B */
	@JsonProperty("plan")
	Plan plan;

	/** �v�����i����j�B */
	@JsonProperty("next_cycle_plan")
	Plan nextCyclePlan;

	/** �X�e�[�^�X�B */
	@JsonProperty("status")
	Status status;

	/** ������ۋ��B */
	@JsonProperty("prorate")
	boolean prorate;

	/** �w�Ǌ��ԊJ�n���B */
	@JsonProperty("current_period_start")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime currentPeriodStart;

	/** �w�Ǌ��ԏI�����B */
	@JsonProperty("current_period_end")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime currentPeriodEnd;

	/** �g���C�A�����ԊJ�n���B */
	@JsonProperty("trial_start")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime trialStart;

	/** �g���C�A�����ԏI�����B */
	@JsonProperty("trial_end")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime trialEmd;

	/** ����ۋ���񎞁B */
	@JsonProperty("canceled_at")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime canceledAt;

	/** ����ۋ���~���B */
	@JsonProperty("resumed_at")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime resumedAt;

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** �ǉ��f�[�^�B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
