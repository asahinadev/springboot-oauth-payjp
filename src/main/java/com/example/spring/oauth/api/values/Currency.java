package com.example.spring.oauth.api.values;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Currency {
	@JsonEnumDefaultValue
	jpy;

	@JsonValue
	public String getJsonValue() {
		return name();
	}
}
