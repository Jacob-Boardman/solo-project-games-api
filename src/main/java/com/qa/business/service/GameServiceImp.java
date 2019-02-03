package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Game;
import com.qa.persistence.repository.GameDBRepository;
import com.qa.util.JSONUtil;

public class GameServiceImp implements GameService{
	
	@Inject
	private GameDBRepository repo;
	
	@Inject
	private JSONUtil util;

	public String createGame(String game) {
		Game aGame = util.getObjectForJSON(game, Game.class);
		
		if(aGame.getAgeRating()>18)
		{
			return "Age Rating can't be greater than 18";
		}
		else {
			return repo.createGame(game);
		}
	}

	public String getAllGames() {
		return repo.getAllGames();
		 
	}

	public String getGameById(Long id) {
		return repo.getGameById(id);
		
	}

	public String updateGame(Long id, String game) {
		Game aGame = util.getObjectForJSON(game, Game.class);
		
		if(aGame.getAgeRating()>18)
		{
			return "Age Rating can't be greater than 18";
		}
		else {
			return repo.updateGame(id, game);
		}
		
	}

	public String deleteGame(Long id) {
		return repo.deleteGame(id);
		
	}

	public String getGamesByGenre(String genre) {
		return repo.getGamesByGenre(genre);
	}

}
