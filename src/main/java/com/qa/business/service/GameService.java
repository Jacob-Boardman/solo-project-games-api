package com.qa.business.service;

public interface GameService {
	String createGame(String game);

	String getAllGames();

	String getGameById(Long id);

	String updateGame(Long id, String game);

	String deleteGame(Long id);
	
	String getGamesByGenre(String genre);
}
