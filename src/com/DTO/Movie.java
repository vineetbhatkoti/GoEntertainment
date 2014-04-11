package com.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {

	String actor;
	int branchid;
	String genre;
	String language;
	String medium;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int movieid;
	String movieName;
	int price;
	int quantity;
	String status;

	public String getActor() {
		return actor;
	}

	public int getBranchid() {
		return branchid;
	}

	public String getGenre() {
		return genre;
	}

	public String getLanguage() {
		return language;
	}

	public String getMedium() {
		return medium;
	}

	public int getMovieid() {
		return movieid;
	}

	public String getMovieName() {
		return movieName;
	}


	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
