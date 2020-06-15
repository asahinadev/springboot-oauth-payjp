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
 * リスト情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class DataList<E> {

	/** 件数。 */
	@JsonProperty("count")
	long count;

	/** データ一覧。 */
	@JsonProperty("data")
	List<E> data;

	/** 次のデータがあるか。 */
	@JsonProperty("has_more")
	boolean more;

	/** オブジェクトタイプ。 */
	@JsonProperty("object")
	String object;

	/** URL。 */
	@JsonProperty("url")
	String url;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** その他情報。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
