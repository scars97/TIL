package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RestTemplateService;

@RestController
@RequestMapping("/rest-template")
public class RestTemplateController {

	private final RestTemplateService restTemplateService;
	
	public RestTemplateController(RestTemplateService restTemplateService) {
		this.restTemplateService = restTemplateService;
	}
	
	@GetMapping
	public String getName() {
		return restTemplateService.getName();
	}
	
	@GetMapping("/path-variable")
	public String getNameWithPathVariable() {
		return restTemplateService.getNameWithPathVariable();
	}
	
	@GetMapping("/parameter")
	public String getNameWithParameter() {
		return restTemplateService.getNameWithParameter();
	}
}
