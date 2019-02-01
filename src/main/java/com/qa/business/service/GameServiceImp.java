package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.GameDBRepository;

public class GameServiceImp implements GameService{
	
	@Inject
	private GameDBRepository repo; 

	public String createGame(String game) {
		return repo.createGame(game);
	}

	public String getAllGames() {
		return repo.getAllGames();
		 
	}

	public String getGameById(Long id) {
		return repo.getGameById(id);
		
	}

	public String updateGame(Long id, String game) {
		return repo.updateGame(id, game);
		
	}

	public String deleteGame(Long id) {
		return repo.deleteGame(id);
		
	}

	public String getGamesBygenre(String genre) {
		return repo.getGamesBygenre(genre);
	}

}
