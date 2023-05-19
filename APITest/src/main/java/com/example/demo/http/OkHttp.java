package com.example.demo.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
public class OkHttp {
	
	@Autowired
	APIkey apiKey;
	
	public String ApiConnection() throws IOException {
		
		OkHttpClient client = new OkHttpClient();
	
		Request request = new Request.Builder()
				.url("https://api-football-v1.p.rapidapi.com/v3/standings?league=39&season=2022")
				.get()
				.addHeader("X-RapidAPI-Key", apiKey.getApiKey())
				.addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
				.build();
	
		Response response = client.newCall(request).execute();
		
		return response.body().string();
			
	}
	
	public List<PremierLeagueDto> premierLeagueDtos(String result){
	
		JSONObject json = new JSONObject(result);
			
		JSONArray responseJson = json.getJSONArray("response");
		JSONObject intJson = (JSONObject) responseJson.get(0);
		JSONObject leagueJson = (JSONObject) intJson.get("league");//league 선택
		JSONArray standingsJson = (JSONArray) leagueJson.get("standings");//standings 배열
		JSONArray intJson2 = (JSONArray) standingsJson.get(0);
			
		List<PremierLeagueDto> plDatas = new ArrayList<>();
		//PL 구단 순위
		for (int i = 0; i < intJson2.length(); i++) {
			JSONObject intJson3 = (JSONObject) intJson2.get(i); // 순위,팀점수
			JSONObject teamJson = intJson3.getJSONObject("team"); // 팀명,팀로고
			JSONObject allJson = intJson3.getJSONObject("all"); // 경기수,성적
				
			PremierLeagueDto preDto = new PremierLeagueDto(intJson3, teamJson, allJson);
			plDatas.add(preDto);
		}
			
		return plDatas; 
	}
}
