package com.example.spring.oauth.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public class Entity {

	@JsonIgnore
	protected static final ObjectMapper om = new ObjectMapper();

	@JsonIgnore
	protected static final LocalDateTime unix_time_base = LocalDateTime.of(1970, 1, 1, 9, 0, 0, 0);

	@JsonAnySetter
	Map<String, Object> attributes = new HashMap<>();

	@JsonIgnore
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public void setAttribute(String key, Object value) {
		getAttributes().put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <A> A getAttribute(String key) {
		return (A) getAttributes().get(key);
	}

	@SuppressWarnings("unchecked")
	public <A> A getAttribute(String key, A defaultValue) {
		return (A) getAttributes().getOrDefault(key, defaultValue);
	}

	@Override
	@SneakyThrows
	public String toString() {
		return om.writeValueAsString(this);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
