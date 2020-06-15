package com.example.spring.oauth.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * ���X�g���B
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class DataList<E> {

	/** �����B */
	@JsonProperty("count")
	long count;

	/** �f�[�^�ꗗ�B */
	@JsonProperty("data")
	List<E> data;

	/** ���̃f�[�^�����邩�B */
	@JsonProperty("has_more")
	boolean more;

	/** �I�u�W�F�N�g�^�C�v�B */
	@JsonProperty("object")
	String object;

	/** URL�B */
	@JsonProperty("url")
	String url;

	/** ���^�f�[�^�B */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** ���̑����B */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
