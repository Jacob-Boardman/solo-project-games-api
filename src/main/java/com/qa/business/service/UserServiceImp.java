package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.UserDBRepository;

public class UserServiceImp implements UserService{
	
	@Inject
	private UserDBRepository repo;

	public String createUser(String user) {
		repo.createUser(user);
		return null;
	}

	public String getAllUsers() {
		repo.getAllUsers();
		return null;
	}

	public String getUserById(Long id) {
		repo.getUserById(id);
		return null;
	}

	public String updateUser(Long id, String user) {
		repo.updateUser(id, user);
		return null;
	}

	public String deleteUser(Long id) {
		repo.deleteUser(id);
		return null;
	}

}
