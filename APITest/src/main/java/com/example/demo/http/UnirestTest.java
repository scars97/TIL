package com.example.demo.http;



import java.io.IOException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UnirestTest {

	
	public void Test() throws UnirestException {
	
		HttpResponse<String> response = Unirest.get("https://api-football-v1.p.rapidapi.com/v3/leagues?id=39")
				.header("X-RapidAPI-Key", "00dff05ec1msh5a3fcefada34491p12c058jsn7a0d02c8ef99")
				.header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
				.asString();

	}
}
