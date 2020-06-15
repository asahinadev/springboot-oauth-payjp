package com.example.spring.oauth.api.values;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransferStatus {
	
	@JsonEnumDefaultValue
	/** �U�����z(\10,000)�ȏ�œ������O�̏�� */
	pending,
	/** ����������̏�� */
	paid,
	/** �����ԈႢ���œ����Ɏ��s������� */
	failed,
	/** PAYJP�̔��f�ŉ����X�l���̓������T�������Ă��������Ă����� */
	stop,
	/** ���v���z��\10,000�ɖ����Ȃ��ꍇ�́A��������ɌJ��z�����s���� */
	carried_over,
	/** �����Ɏ��s���A����������ɑg�ݖ߂��萔�������������� */
	recombination,

	;

	@JsonValue
	public String getJsonValue() {
		return name();
	}
}
