package com.example.spring.oauth.api.values;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {

	/** 400 : リクエストエラー 。 */
	client_error,
	/** 402 : カードに関するエラー。 */
	card_error,
	/** 402 : 決済ネットワーク側のエラー。 */
	server_error,
	/** 404 : 存在しないオブジェクト 。 */
	not_found_error,
	/** 405 : 許可されていないメソッドエラー 。 */
	not_allowed_method_error,
	/** 401 : 認証エラー 。 */
	auth_error,
	/** 500: 無効なリクエスト。 */
	invalid_request_error,
	;

	@JsonValue
	public String getJsonValue() {
		return name();
	}
}
