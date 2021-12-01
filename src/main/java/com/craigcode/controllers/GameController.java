package com.craigcode.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.craigcode.models.Game;
import com.craigcode.services.Turn;
import com.craigcode.services.UnoGameAPI;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class GameController {

	@PostMapping("/games")//creates game
	Turn postGame(@RequestBody Game game) {
		System.out.println(game);
		Turn start = null;
		UnoGameAPI gameAPI = UnoGameAPI.getGame(game.getGameId());
		start = gameAPI.getTurn();
		return start;

		// Use the UnoGameAPI to
		// 1. Return the current game turn of an existing game.
		// 2. Or create a new game and return the first turn.
		// 3. Post should not advance the game
	}

	@GetMapping("/games")
	List<Game> getGames() {

		String[] names = UnoGameAPI.getGameKeys();

		List<Game> games = new ArrayList<>();
		for (String name : names) {
			games.add(new Game(name));
		}

		return games;
		// Use the UnoGameAPI to
		// 1. Get all existing game names
		// 2. This is a new method for the UnoGameAPI
	}

	@PutMapping("/games")
	Turn getTurn(@RequestBody Game game) {
		if (UnoGameAPI.hasGameKey(game.getGameId())) {

			UnoGameAPI gameAPI = UnoGameAPI.getGame(game.getGameId());
			gameAPI.nextTurn();
			Turn turn = gameAPI.getTurn();
			return turn;
		}

		// Use the UnoGameAPI to
		// 1. Get a game turn for the given game key (name).
		// 2. When the game is over, keep returning the last turn.
		// 3. Do not create a game if the game key is unknown
		// 4. Instead, when game key is not known:
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");

	}
}
