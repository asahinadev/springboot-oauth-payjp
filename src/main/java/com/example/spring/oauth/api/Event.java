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
 * �G���[���B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Event {

	public static final SingleType<Event> TYPE = new SingleType<>();
	public static final ListType<Event> LIST = new ListType<>();

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

	/**
	 * �C�x���g�^�C�v�B
	 * 
	 * <ul>
	 * <li>charge.succeeded �x�����̐���
	 * <li>charge.failed �x�����̎��s
	 * <li>charge.updated �x�����̍X�V
	 * <li>charge.refunded �x�����̕ԋ�
	 * <li>charge.captured �x�����̊m��
	 * <li>token.created �g�[�N���̍쐬
	 * <li>customer.created �ڋq�̍쐬
	 * <li>customer.updated �ڋq�̍X�V
	 * <li>customer.deleted �ڋq�̍폜
	 * <li>customer.card.created �ڋq�̃J�[�h�쐬
	 * <li>customer.card.updated �ڋq�̃J�[�h�X�V
	 * <li>customer.card.deleted �ڋq�̃J�[�h�폜
	 * <li>plan.created �v�����̍쐬 plan.updated �v�����̍X�V
	 * <li>plan.deleted �v�����̍폜
	 * <li>subscription.created ����ۋ��̍쐬
	 * <li>subscription.updated ����ۋ��̍X�V
	 * <li>subscription.deleted ����ۋ��̍폜
	 * <li>subscription.paused ����ۋ��̒�~
	 * <li>subscription.resumed ����ۋ��̍ĊJ
	 * <li>subscription.canceled ����ۋ��̃L�����Z��
	 * <li>subscription.renewed ����ۋ��̊��ԍX�V
	 * <li>transfer.succeeded �������e�̊m��
	 * <li>tenant.updated �e�i���g���̍X�V�A�{�Ԑ\��(����E�X�V�܂�)�A���Ђɂ��R�����ʔ��f
	 */
	@JsonProperty("type")
	String type;

	/** �C�x���g�Ώۃf�[�^�B */
	@JsonProperty("created")
	Any data;

	/** �ݒ肳�ꂽURL�ւ̒ʒm���������Ă��Ȃ������B */
	@JsonProperty("pending_webhooks ")
	int pending;

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** ���̑����B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
