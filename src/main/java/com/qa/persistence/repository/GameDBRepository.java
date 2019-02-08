package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Game;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class GameDBRepository implements GameRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Transactional(REQUIRED)
	public String createGame(String game) {
		Game newGame = util.getObjectForJSON(game, Game.class);
		manager.persist(newGame);
		return "Message : Created a new Game";
	}

	public String getAllGames() {
		Query query = manager.createQuery("SELECT g FROM Game g");
		Collection<Game> games = (Collection<Game>) query.getResultList();
		return util.getJSONForObject(games);
	
	}
	
	@Transactional(REQUIRED)
	public String getGameById(Long id) {
		Query query = manager.createQuery("SELECT g FROM Game g WHERE g.id = " + id);
		Game games = (Game) query.getSingleResult();
		return util.getJSONForObject(games);
	}

	@Transactional(REQUIRED)
	public String updateGame(Long id, String game) {
		Game foundGame = findGame(id);
		Game newGame = util.getObjectForJSON(game, Game.class);
		if (foundGame != null) {
			manager.remove(foundGame);
			manager.persist(newGame);
			return "Message: Game has been updated";
		}
		return "Message : No Game found";
	}

	@Transactional(REQUIRED)
	public String deleteGame(Long id) {
		Game foundGame = findGame(id);
		if (foundGame != null) {
			manager.remove(foundGame);
			return "Message: Game has been deleted";
		}
		return "Message : No Game found";
	}

	public String getGamesByGenre(String genre) {
		Query query = manager.createQuery("SELECT g FROM Game g WHERE g.gameGenre LIKE '" + genre + "'");
		Collection<Game> games = (Collection<Game>) query.getResultList();
		return util.getJSONForObject(games);
	}
	
	public Game findGame(Long id) {
		return manager.find(Game.class, id);
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}


}
