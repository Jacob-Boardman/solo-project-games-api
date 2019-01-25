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
import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class UserDBRepository implements UserRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Transactional(REQUIRED)
	public String createUser(String user) {
		Game newUser = util.getObjectForJSON(user, Game.class);
		manager.persist(newUser);
		return "Message : Created a new User";
	}

	public String getAllUsers() {
		Query query = manager.createQuery("SELECT u FROM User u");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}
	
	@Transactional(REQUIRED)
	public String getUserById(Long id) {
		Query query = manager.createQuery("SELECT u FROM User u WHERE id = " + id);
		User user = (User) query.getSingleResult();
		return util.getJSONForObject(user);
	}

	@Transactional(REQUIRED)
	public String updateUser(Long id, String user) {
		User foundUser = findUser(id);
		Game newUser = util.getObjectForJSON(user, Game.class);
		if (foundUser != null) {
			manager.remove(foundUser);
			manager.persist(newUser);
			return "Message : User has been updated";
		}
		return "Message : No user found";
	}

	@Transactional(REQUIRED)
	public String deleteUser(Long id) {
		User foundUser = findUser(id);
		if (foundUser != null) {
			manager.remove(foundUser);

			return "Message : User has been deleted";
		}
		return "Message : No user found";
	}

	public User findUser(Long id) {
		return manager.find(User.class, id);
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
