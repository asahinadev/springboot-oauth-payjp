package com.example.spring.oauth.serializer;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.fasterxml.jackson.databind.util.StdConverter;

public class UnixTimeSerializer
		extends StdConverter<LocalDateTime, Integer> {

	@Override
	public Integer convert(LocalDateTime value) {
		return ((Long) value.toEpochSecond(ZoneOffset.ofHours(9))).intValue();
	}

}
