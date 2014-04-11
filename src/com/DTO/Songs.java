package com.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "songs")
public class Songs implements Serializable {

	String album;
	String artist;
	int branchid;
	String genre;
	String language;
	String medium;
	int price;
	int quantity;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int songid;
	String status;



	public String getAlbum() {
		return album;
	}

	public String getArtist() {
		return artist;
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

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getSongid() {
		return songid;
	}

	public String getStatus() {
		return status;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setArtist(String artist) {
		this.artist = artist;
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

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setSongid(int songid) {
		this.songid = songid;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
