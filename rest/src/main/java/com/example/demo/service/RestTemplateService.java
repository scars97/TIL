package com.example.demo.service;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RestTemplateService {

	public String getName() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")//호출하고자 하는 URL 입력
				.path("/api/v1/crud-api")// 세부경로 입력
				.encode()//기본 UTF-8
				.build()//빌더 생성 종료
				.toUri();//URI 타입으로 리턴
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		return responseEntity.getBody();
	}
	
	public String getNameWithPathVariable() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/v1/crud-api/{name}")
				.encode()
				.build()
				.expand("Flature")//복수의 값을 넣어야할 경우 , 를 추가하여 구분
				.toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		return responseEntity.getBody();
	}
	
	public String getNameWithParameter() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/v1/crud-api/param")
				.queryParam("name", "Flature")
				.encode()
				.build()
				.toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		return responseEntity.getBody();
		
	}
}
