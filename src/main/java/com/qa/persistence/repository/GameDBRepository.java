package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllGames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(REQUIRED)
	public String updateGame(Long id, String game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(REQUIRED)
	public String deleteGame(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void findGame(EntityManager manager) {
		this.manager = manager;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
