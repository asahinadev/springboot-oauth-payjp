package com.example.spring.oauth.api;

import java.util.HashMap;
import java.util.Map;

import com.example.spring.oauth.api.parameterized.SingleType;
import com.example.spring.oauth.api.values.ErrorType;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * エラー情報。
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Error {

	public static final SingleType<Error> TYPE = new SingleType<>();

	/**
	 * TODO 処理ステータス.
	 * 
	 * 200 リクエスト成功<br>
	 * 400 不正なパラメーターなどのリクエストエラー<br>
	 * 401 APIキーの認証エラー<br>
	 * 402 カード認証・支払いエラー<br>
	 * 404 存在しないAPIリソース<br>
	 * 500 PAY.JPや決済ネットワークでの障害<br>
	 */
	int status;

	/**
	 * エラータイプ.
	 */
	ErrorType type;

	/**
	 * TODO エラーメッセージ.
	 * 
	 * invalid_number 不正なカード番号<br>
	 * invalid_cvc 不正なCVC<br>
	 * invalid_expiration_date 不正な有効期限年、または月<br>
	 * invalid_expiry_month 不正な有効期限月<br>
	 * invalid_expiry_year 不正な有効期限年<br>
	 * expired_card 有効期限切れ<br>
	 * card_declined カード会社によって拒否されたカード<br>
	 * processing_error 決済ネットワーク上で生じたエラー<br>
	 * missing_card 顧客がカードを保持していない<br>
	 * unacceptable_brand 対象のカードブランドが許可されていない<br>
	 * invalid_id 不正なID<br>
	 * no_api_key APIキーがセットされていない<br>
	 * invalid_api_key 不正なAPIキー<br>
	 * invalid_plan 不正なプラン<br>
	 * invalid_expiry_days 不正な失効日数<br>
	 * unnecessary_expiry_days 失効日数が不要なパラメーターである場合<br>
	 * invalid_flexible_id 不正なID指定<br>
	 * invalid_timestamp 不正なUnixタイムスタンプ<br>
	 * invalid_trial_end 不正なトライアル終了日<br>
	 * invalid_string_length 不正な文字列長<br>
	 * invalid_country 不正な国名コード<br>
	 * invalid_currency 不正な通貨コード<br>
	 * invalid_address_zip 不正な郵便番号<br>
	 * invalid_amount 不正な支払い金額<br>
	 * invalid_plan_amount 不正なプラン金額<br>
	 * invalid_card 不正なカード<br>
	 * invalid_card_name 不正なカードホルダー名<br>
	 * invalid_card_country 不正なカード請求先国名コード<br>
	 * invalid_card_address_zip 不正なカード請求先住所(郵便番号)<br>
	 * invalid_card_address_state 不正なカード請求先住所(都道府県)<br>
	 * invalid_card_address_city 不正なカード請求先住所(市区町村)<br>
	 * invalid_card_address_line 不正なカード請求先住所(番地など)<br>
	 * invalid_customer 不正な顧客<br>
	 * invalid_boolean 不正な論理値<br>
	 * invalid_email 不正なメールアドレス<br>
	 * no_allowed_param パラメーターが許可されていない場合<br>
	 * no_param パラメーターが何もセットされていない<br>
	 * invalid_querystring 不正なクエリー文字列<br>
	 * missing_param 必要なパラメーターがセットされていない<br>
	 * invalid_param_key 指定できない不正なパラメーターがある<br>
	 * no_payment_method 支払い手段がセットされていない<br>
	 * payment_method_duplicate 支払い手段が重複してセットされている<br>
	 * payment_method_duplicate_including_customer 支払い手段が重複してセットされている(顧客IDを含む)<br>
	 * failed_payment 指定した支払いが失敗している場合<br>
	 * invalid_refund_amount 不正な返金額<br>
	 * already_refunded すでに返金済み<br>
	 * invalid_amount_to_not_captured 確定されていない支払いに対して部分返金ができない<br>
	 * refund_amount_gt_net 返金額が元の支払い額より大きい<br>
	 * capture_amount_gt_net 支払い確定額が元の支払い額より大きい<br>
	 * invalid_refund_reason 不正な返金理由<br>
	 * already_captured すでに支払いが確定済み<br>
	 * cant_capture_refunded_charge 返金済みの支払いに対して支払い確定はできない<br>
	 * cant_reauth_refunded_charge 返金済みの支払いに対して再認証はできない<br>
	 * charge_expired 認証が失効している支払い<br>
	 * already_exist_id すでに存在しているID<br>
	 * token_already_used すでに使用済みのトークン<br>
	 * already_have_card 指定した顧客がすでに保持しているカード<br>
	 * dont_has_this_card 顧客が指定したカードを保持していない<br>
	 * doesnt_have_card 顧客がカードを何も保持していない<br>
	 * already_have_the_same_card すでに同じカード番号、有効期限のカードを保持している<br>
	 * invalid_interval 不正な課金周期<br>
	 * invalid_trial_days 不正なトライアル日数<br>
	 * invalid_billing_day 不正な支払い実行日<br>
	 * billing_day_for_non_monthly_plan 支払い実行日は月次プランにしか指定できない<br>
	 * exist_subscribers 購入者が存在するプランは削除できない<br>
	 * already_subscribed すでに定期課金済みの顧客<br>
	 * already_canceled すでにキャンセル済みの定期課金<br>
	 * already_paused すでに停止済みの定期課金<br>
	 * subscription_worked すでに稼働している定期課金<br>
	 * cannot_change_prorate_status 日割り課金の設定はプラン変更時のみ可能<br>
	 * too_many_metadata_keys metadataキーの登録上限(20)を超過している<br>
	 * invalid_metadata_key 不正なmetadataキー<br>
	 * invalid_metadata_value 不正なmetadataバリュー<br>
	 * apple_pay_disabled_in_livemode 本番モードのApple Pay利用が許可されていない<br>
	 * invalid_apple_pay_token 不正なApple Payトークン<br>
	 * test_card_on_livemode 本番モードのリクエストにテストカードが使用されている<br>
	 * not_activated_account 本番モードが許可されていないアカウント<br>
	 * too_many_test_request テストモードのリクエストリミットを超過している<br>
	 * payjp_wrong PAY.JPのサーバー側でエラーが発生している<br>
	 * pg_wrong 決済代行会社のサーバー側でエラーが発生している<br>
	 * not_found リクエスト先が存在しないことを示す<br>
	 * not_allowed_method 許可されていないHTTPメソッド<br>
	 */
	String message;

	/** メタデータ。 */
	@JsonProperty("metadata")
	Map<String, Object> metadata = new HashMap<>();

	/** その他情報。 */
	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();
}
