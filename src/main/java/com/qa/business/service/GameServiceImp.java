package com.qa.business.service;

import java.util.ArrayList;
import java.util.List;

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
		
		if(isValidGame(aGame).size() > 0)
		{
			return isValidGame(aGame).toString();
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
		
		if(isValidGame(aGame).size() > 0)
		{
			return isValidGame(aGame).toString();
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
	
	public List<String> isValidGame(Game game){
		List<String> errors = new ArrayList<String>();
		
		if(game.getAgeRating() < 3 || game.getAgeRating() > 18) {
			errors.add("Games age rating can only be ages 3-18");
		}
		if(game.getTitle().length() < 2 || game.getTitle().length() > 100) {
			errors.add("Title can only be between 2-100 characters");
		}
		
		return errors;
	}

}
