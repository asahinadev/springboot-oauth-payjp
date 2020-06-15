package com.example.spring.oauth.confg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "app.payjpapi.config")
public class PayjpApiConfig {

	String baseurl = "https://api.pay.jp/v1/";
	String privateKey;
	String publicKey;

}
