package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.UserDBRepository;

public class UserServiceImp implements UserService{
	
	@Inject
	private UserDBRepository repo;

	public String createUser(String user) {
		return repo.createUser(user);
	}

	public String getAllUsers() {
		return repo.getAllUsers();
	}

	public String getUserById(Long id) {
		return repo.getUserById(id);
		
	}

	public String updateUser(Long id, String user) {
		return repo.updateUser(id, user);
		
	}

	public String deleteUser(Long id) {
		return repo.deleteUser(id);
		
	}

}
