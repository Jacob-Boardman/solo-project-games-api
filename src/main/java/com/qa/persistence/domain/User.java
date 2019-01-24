package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String firstName;
	private String secondName;
	private Long age;
	private String gameGenre;
	
	public User() {
		//Has to be empty
	}
	
	public User(String firstName, String secondName, Long age, String gameGenre) {
		this.setFirstName(firstName);
		this.setSecondName(secondName);
		this.setAge(age);
		this.setGameGenre(gameGenre);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getGameGenre() {
		return gameGenre;
	}

	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}
	
	
}
