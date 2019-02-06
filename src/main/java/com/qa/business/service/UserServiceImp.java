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
		List<String> errors = new ArrayList<String>();
		
		if(aUser.getAge() > 120) {
			errors.add("Age can not be greater than 120");
		}
		if(aUser.getFirstName().length() == 0) {
			 errors.add("Please fill out First Name");
		}
		if(aUser.getSecondName().length() == 0){
			errors.add("Please fill out Second Name");
		}
		if(!isAlpha(aUser.getFirstName())){
			errors.add("First Name can only contain a-z and A-Z");
		}
		if(!isAlpha(aUser.getSecondName())){
			errors.add("Second Name can only contain a-z and A-Z");
		}	
		
		if(errors.size() > 0){
			return errors.toString();
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
		List<String> errors = new ArrayList<String>();
		
		if(aUser.getAge() > 120) {
			errors.add("Age can not be greater than 120");
		}
		if(aUser.getFirstName().length() == 0) {
			 errors.add("Please fill out First Name");
		}
		if(aUser.getSecondName().length() == 0){
			errors.add("Please fill out Second Name");
		}
		if(!isAlpha(aUser.getFirstName())){
			errors.add("First Name can only contain a-z and A-Z");
		}
		if(!isAlpha(aUser.getSecondName())){
			errors.add("Second Name can only contain a-z and A-Z");
		}	
		
		if(errors.size() > 0){
			return errors.toString();
		}else {			
			return repo.createUser(user);
		}
		
	}

	public String deleteUser(Long id) {
		return repo.deleteUser(id);
		
	}
	
	public boolean isAlpha(String name) {
	    return name.matches("[a-zA-Z]+");
	}

}
