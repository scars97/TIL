package com.example.demo.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaNetHttp {

	public void test() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/leagues?id=39"))
				.header("X-RapidAPI-Key", "00dff05ec1msh5a3fcefada34491p12c058jsn7a0d02c8ef99")
				.header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

	}
}
