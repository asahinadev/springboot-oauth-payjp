package com.example.spring.oauth.api.values;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Country {
	@JsonEnumDefaultValue
	JP;

	@JsonValue
	public String getJsonValue() {
		return name();
	}
}
