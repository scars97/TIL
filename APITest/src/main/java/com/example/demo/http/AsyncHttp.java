package com.example.demo.http;

import java.io.IOException;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

public class AsyncHttp {

	public void test() throws IOException {
		AsyncHttpClient client = new DefaultAsyncHttpClient();
		client.prepare("GET", "https://api-football-v1.p.rapidapi.com/v3/leagues?id=39")
			.setHeader("X-RapidAPI-Key", "00dff05ec1msh5a3fcefada34491p12c058jsn7a0d02c8ef99")
			.setHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
			.execute()
			.toCompletableFuture()
			.thenAccept(System.out::println)
			.join();
	
		client.close();
	}
}
