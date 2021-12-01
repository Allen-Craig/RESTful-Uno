package com.craigcode.models;

import org.springframework.stereotype.Component;

@Component // tells Spring that this is a component it can create
public class Game {

	@Override
	public String toString() {//allows us to print game
		return "Game [gameId=" + gameId + "]";
	}

	private String gameId;

	public Game() {//default constructor, Spring cannot use parameters
		super();

	}

	public Game(String gameId) {//our constructor
		super();
		this.gameId = gameId;
	}

	public String getGameId() {//getter for game ID
		return gameId;
	}

}//allows us to transmit a game ID to the POST method 
