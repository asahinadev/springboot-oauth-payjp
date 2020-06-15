package com.example.spring.oauth.api.values;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
	@JsonEnumDefaultValue
	trial, active, canceled, paused;

	@JsonValue
	public String getJsonValue() {
		return name();
	}
}
