package com.example.demo.http;

import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PremierLeagueDto {

	private int rank;
	private String teamName;
	private int points;
	private int played;
	private int win;
	private int draw;
	private int lose;
	
	public PremierLeagueDto(JSONObject intJson, JSONObject teamJson, JSONObject allJson) {
		this.rank = intJson.getInt("rank");
		this.teamName = teamJson.getString("name");
		this.points = intJson.getInt("points");
		this.played = allJson.getInt("played");
		this.win = allJson.getInt("win");
		this.draw = allJson.getInt("draw");
		this.lose = allJson.getInt("lose");
	}
}
