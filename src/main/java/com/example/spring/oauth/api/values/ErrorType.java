package com.example.spring.oauth.api.values;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {

	/** 400 : ���N�G�X�g�G���[ �B */
	client_error,
	/** 402 : �J�[�h�Ɋւ���G���[�B */
	card_error,
	/** 402 : ���σl�b�g���[�N���̃G���[�B */
	server_error,
	/** 404 : ���݂��Ȃ��I�u�W�F�N�g �B */
	not_found_error,
	/** 405 : ������Ă��Ȃ����\�b�h�G���[ �B */
	not_allowed_method_error,
	/** 401 : �F�؃G���[ �B */
	auth_error,
	/** 500: �����ȃ��N�G�X�g�B */
	invalid_request_error,
	;

	@JsonValue
	public String getJsonValue() {
		return name();
	}
}
