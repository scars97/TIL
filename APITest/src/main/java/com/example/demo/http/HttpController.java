package com.example.demo.http;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {
	
	private final OkHttp okHttp;
	
	public HttpController(OkHttp okHttp) {
		this.okHttp = okHttp;
	}
	
	@GetMapping("/epl")
	public List<PremierLeagueDto> getData() throws IOException{
		
		String result = okHttp.ApiConnection();
		List<PremierLeagueDto> standings = okHttp.premierLeagueDtos(result);
		
		return standings;
	}

}
