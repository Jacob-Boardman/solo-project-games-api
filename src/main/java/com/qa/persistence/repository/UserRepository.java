package com.qa.persistence.repository;

public interface UserRepository {
	
	String createUser(String user);
	
	String getAllUsers();
	
	String getUserById(Long id);
	
	String updateUser(Long id, String user);
	
	String deleteUser(Long id);

}
