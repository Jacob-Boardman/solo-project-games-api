package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String title;
	private Long ageRating;
	private String gameGenre;

	public Game() {
		// has to be empty
	}

	public Game(String title, Long ageRating, String gameGenre) {
		this.setTitle(title);
		this.setAgeRating(ageRating);
		this.setGameGenre(gameGenre);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(Long ageRating) {
		this.ageRating = ageRating;
	}

	public String getGamegenre() {
		return gameGenre;
	}

	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}

}
