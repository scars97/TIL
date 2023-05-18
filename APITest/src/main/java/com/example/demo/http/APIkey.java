package com.example.demo.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class APIkey {

	@Value("${apiFootball-key}")
	private String apiKey;

}
