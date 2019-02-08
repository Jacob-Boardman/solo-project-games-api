package com.qa.business.service;

import java.util.ArrayList;
import java.util.List;

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
		
		if(!isValidUser(aUser).isEmpty()) {
			return isValidUser(aUser).toString();
		}else {
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
		
		if(!isValidUser(aUser).isEmpty()) {
			return isValidUser(aUser).toString();
		}else {
			return repo.updateUser(id, user);
		}

		
	}

	public String deleteUser(Long id) {
		return repo.deleteUser(id);
		
	}
	
	public boolean isAlpha(String name) {
	    return name.matches("[a-zA-Z]+");
	}
	
	public List<String> isValidUser(User user) {
		
		List<String> errors = new ArrayList<>();
		
		if(user.getAge() > 120 || user.getAge() < 3) {
			errors.add("Age has to be between 3 and 120");
		}
		if(user.getFirstName().length() == 0) {
			 errors.add("Please fill out First Name");
		}
		if(user.getSecondName().length() == 0){
			errors.add("Please fill out Second Name");
		}
		if(!isAlpha(user.getFirstName())){
			errors.add("First Name can only contain a-z and A-Z");
		}
		if(!isAlpha(user.getSecondName())){
			errors.add("Second Name can only contain a-z and A-Z");
		}	
		
		return errors;
		
	}
	
	

}
