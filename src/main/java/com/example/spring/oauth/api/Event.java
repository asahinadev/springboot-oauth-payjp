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
 * エラー情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Event {

	public static final SingleType<Event> TYPE = new SingleType<>();
	public static final ListType<Event> LIST = new ListType<>();

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

	/**
	 * イベントタイプ。
	 * 
	 * <ul>
	 * <li>charge.succeeded 支払いの成功
	 * <li>charge.failed 支払いの失敗
	 * <li>charge.updated 支払いの更新
	 * <li>charge.refunded 支払いの返金
	 * <li>charge.captured 支払いの確定
	 * <li>token.created トークンの作成
	 * <li>customer.created 顧客の作成
	 * <li>customer.updated 顧客の更新
	 * <li>customer.deleted 顧客の削除
	 * <li>customer.card.created 顧客のカード作成
	 * <li>customer.card.updated 顧客のカード更新
	 * <li>customer.card.deleted 顧客のカード削除
	 * <li>plan.created プランの作成 plan.updated プランの更新
	 * <li>plan.deleted プランの削除
	 * <li>subscription.created 定期課金の作成
	 * <li>subscription.updated 定期課金の更新
	 * <li>subscription.deleted 定期課金の削除
	 * <li>subscription.paused 定期課金の停止
	 * <li>subscription.resumed 定期課金の再開
	 * <li>subscription.canceled 定期課金のキャンセル
	 * <li>subscription.renewed 定期課金の期間更新
	 * <li>transfer.succeeded 入金内容の確定
	 * <li>tenant.updated テナント情報の更新、本番申請(初回・更新含む)、弊社による審査結果反映
	 */
	@JsonProperty("type")
	String type;

	/** イベント対象データ。 */
	@JsonProperty("created")
	Any data;

	/** 設定されたURLへの通知が完了していない件数。 */
	@JsonProperty("pending_webhooks ")
	int pending;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** その他情報。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
