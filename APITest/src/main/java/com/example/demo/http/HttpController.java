package com.example.demo.http;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {
	
	private final OkHttp okHttp;
	
	public HttpController(OkHttp okHttp) {
		this.okHttp = okHttp;
	}

}
