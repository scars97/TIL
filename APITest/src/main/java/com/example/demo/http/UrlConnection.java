package com.example.demo.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class UrlConnection {


	public void Connection() {
		
		try {
			
			URL url = new URL("https://api-football-v1.p.rapidapi.com/v3/standings?league=39&season=2022");
		
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			conn.getHeaderFields();
			
			System.out.println(conn.getResponseCode()); 
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}


