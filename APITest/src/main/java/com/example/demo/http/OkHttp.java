package com.example.demo.http;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp {
	
	public void OkHttpTest() throws IOException {

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://api-football-v1.p.rapidapi.com/v3/leagues?id=39")
				.get()
				.addHeader("X-RapidAPI-Key", "00dff05ec1msh5a3fcefada34491p12c058jsn7a0d02c8ef99")
				.addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
				.build();

			Response response = client.newCall(request).execute();

	}
}
