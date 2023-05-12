package com.example.demo.http;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class OkHttp {
	
	public static void main(String[] args) {
	
		try {
			OkHttpClient client = new OkHttpClient();
	
			Request request = new Request.Builder()
					.url("https://api-football-v1.p.rapidapi.com/v3/standings?league=39&season=2022")
					.get()
					.addHeader("X-RapidAPI-Key", "00dff05ec1msh5a3fcefada34491p12c058jsn7a0d02c8ef99")
					.addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
					.build();
	
			Response response = client.newCall(request).execute();
			
			String result = response.body().string();
			
			JSONObject json = new JSONObject(result);
			
			JSONArray responseJson = json.getJSONArray("response");
			JSONObject intJson = (JSONObject) responseJson.get(0);
			JSONObject leagueJson = (JSONObject) intJson.get("league");//league 선택
			JSONArray standingsJson = (JSONArray) leagueJson.get("standings");//standings 배열
			JSONArray intJson2 = (JSONArray) standingsJson.get(0);
			JSONObject intJson3 = (JSONObject) intJson2.get(0);
			JSONObject teamJson = intJson3.getJSONObject("team");
			JSONObject allJson = intJson3.getJSONObject("all");

			String logo = (String) teamJson.get("logo");
			String name = (String) teamJson.get("name");
			int played = (int) allJson.get("played");
			int points = (int) intJson3.get("points");
			int win = (int) allJson.get("win");
			int draw = (int) allJson.get("draw");
			int lose = (int) allJson.get("lose");
			System.out.println("Logo : " + logo + "\n" +
							   "Team : " + name + "\n" +
							   "Played : " + played + "\n" +
							   "Points : " + points+ "\n" +
							   "Win : " + win + "\n" +
							   "Draw : " + draw + "\n" +
							   "Lose : " + lose);
						
		}catch(IOException e) {
			e.printStackTrace();
		}			
	}
}
