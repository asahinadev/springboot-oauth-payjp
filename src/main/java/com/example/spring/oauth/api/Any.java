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
 * 不定形式情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Any {

	public static final SingleType<Any> TYPE = new SingleType<>();
	public static final ListType<Any> LIST = new ListType<>();

	/** 識別子。 */
	@JsonProperty("id")
	String id;

	/** 本番判定。 */
	@JsonProperty("livemode")
	boolean livemode;

	/** オブジェクトタイプ。 */
	@JsonProperty("object")
	String object;

	/** 作成日時。 */
	@JsonProperty("created")
	@JsonSerialize(converter = UnixTimeSerializer.class)
	@JsonDeserialize(converter = UnixTimeDeserializer.class)
	LocalDateTime created;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** 追加データ。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
