package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.GameDBRepository;

public class GameServiceImp implements GameService{
	
	@Inject
	private GameDBRepository repo; 

	public String createGame(String game) {
		repo.createGame(game);
		return null;
	}

	public String getAllGames() {
		repo.getAllGames();
		return null;
	}

	public String getGameById(Long id) {
		repo.getGameById(id);
		return null;
	}

	public String updateGame(Long id, String game) {
		repo.updateGame(id, game);
		return null;
	}

	public String deleteGame(Long id) {
		repo.deleteGame(id);
		return null;
	}

}
