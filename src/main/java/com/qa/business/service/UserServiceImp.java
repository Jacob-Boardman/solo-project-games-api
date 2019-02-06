package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserDBRepository;
import com.qa.util.JSONUtil;

public class UserServiceImp implements UserService{
	
	@Inject
	private UserDBRepository repo;
	
	@Inject
	private JSONUtil util;

	public String createUser(String user) {
		User aUser = util.getObjectForJSON(user, User.class);
		
		if(aUser.getAge() > 120) {
			return "Age can not be greater than 120";
		}
		else {
			return repo.createUser(user);
		}
	}

	public String getAllUsers() {
		return repo.getAllUsers();
	}

	public String getUserById(Long id) {
		return repo.getUserById(id);
		
	}

	public String updateUser(Long id, String user) {
		User aUser = util.getObjectForJSON(user, User.class);
		
		if(aUser.getAge() > 120) {
			return "Age can't be that old";
		}
		else {
			return repo.updateUser(id, user);
		}
		
	}

	public String deleteUser(Long id) {
		return repo.deleteUser(id);
		
	}

}
