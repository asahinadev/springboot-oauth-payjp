package com.example.spring.oauth.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.util.StdConverter;

public class UnixTimeDeserializer
		extends StdConverter<Integer, LocalDateTime> {

	@Override
	public LocalDateTime convert(Integer value) {
		return LocalDateTime.of(1970, 1, 1, 0, 0, 0, 0).plusSeconds(value);
	}

}
