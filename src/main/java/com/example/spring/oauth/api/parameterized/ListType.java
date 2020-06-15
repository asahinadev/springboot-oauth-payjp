package com.example.spring.oauth.api.parameterized;

import org.springframework.core.ParameterizedTypeReference;

import com.example.spring.oauth.api.DataList;

public class ListType<E> extends ParameterizedTypeReference<DataList<E>> {

}
