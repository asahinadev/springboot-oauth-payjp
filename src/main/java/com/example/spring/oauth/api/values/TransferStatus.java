package com.example.spring.oauth.api.values;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransferStatus {
	
	@JsonEnumDefaultValue
	/** 振込金額(\10,000)以上で入金日前の状態 */
	pending,
	/** 入金完了後の状態 */
	paid,
	/** 口座間違い等で入金に失敗した状態 */
	failed,
	/** PAYJPの判断で加盟店様側の入金を控えさせていただいている状態 */
	stop,
	/** 合計金額が\10,000に満たない場合は、次回入金に繰り越しが行われる */
	carried_over,
	/** 入金に失敗し、次回入金時に組み戻し手数料が発生する状態 */
	recombination,

	;

	@JsonValue
	public String getJsonValue() {
		return name();
	}
}
