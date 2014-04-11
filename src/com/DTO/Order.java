package com.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order implements Serializable {
	String actor;
	String album;

	String artist;

	int branchid;

	String genre;

	String language;

	String medium;
	String movieName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderid;
	int quantity;
	int totalPrice;

	public Order() {
		super();
	}

	public String getActor() {
		return actor;
	}

	public String getAlbum() {
		return album;
	}

	public String getArtist() {
		return artist;
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

	public String getMovieName() {
		return movieName;
	}

	public int getOrderid() {
		return orderid;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setArtist(String artist) {
		this.artist = artist;
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

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
