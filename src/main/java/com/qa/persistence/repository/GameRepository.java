package com.qa.persistence.repository;

public interface GameRepository {
	
	String createGame(String game);
	
	String getAllGames();
	
	String getGameById(Long id);
	
	String updateGame(Long id, String game);
	
	String deleteGame(Long id);

}
