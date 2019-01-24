package com.qa.business.service;

public interface UserService {
	String createUser(String user);
	
	String getAllUsers();
	
	String getUserById(Long id);
	
	String updateUser(Long id, String user);
	
	String deleteUser(Long id);

}
