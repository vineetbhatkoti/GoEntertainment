package com.managedBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.DTO.Member;
import com.DTO.Movie;
import com.DTO.Songs;
import com.business.Admin;


public class AdminBean {
	Logger logger = Logger.getLogger(AdminBean.class);
	String actor;
	String album;
	String artist;
	int branchid;
	private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();
	String genre;

	String language;

	String medium;

	List<Member> member1;

	public List<Movie> movielist;

	String movieName;

	public String password;

	int price;

	int quantity;

	public List<Songs> song;
	public List<Songs> songlist;
	
	public List<Movie> updateMovie;
	public List<Songs> updateSong;
	public String userName;

	public AdminBean() {
	}

	public String addInventory() {
		return "addInventory";
	}

	public String addMovie() {
		Admin admin = new Admin();

		Movie song = new Movie();

		song.setGenre(genre);
		song.setActor(actor);
		song.setMovieName(movieName);
		song.setLanguage(language);
		song.setMedium(medium);
		song.setPrice(price);
		song.setQuantity(quantity);

		admin.addMovie(song, branchid);

		return password;

	}

	public String addSong() {
		Admin admin = new Admin();

		Songs song = new Songs();

		song.setGenre(genre);
		song.setArtist(artist);
		song.setAlbum(album);
		song.setLanguage(language);
		song.setMedium(medium);
		song.setPrice(price);
		song.setQuantity(quantity);

		admin.addSong(song, branchid);

		return password;

	}

	
	public String adminAuthenticate() {
		logger.info(" Authenticating the Admin");
		Admin admin = new Admin();
		String j = admin.adminAuthenticate(userName, password);
		return j;

	}

	public String delete_movie() {
		logger.info("Deleting the Movie");
		updateMovie = new ArrayList<Movie>();
		System.out.println(" size of list" + movielist.size());
		for (Movie data : movielist) {
			if (checked.get(data.getMovieid())) {
				System.out.println(data.getQuantity());
				System.out.println(data.getPrice());
				updateMovie.add(data);
			}
		}
		int j = updateMovie.size();
		Admin admin = new Admin();
		admin.deleteMovie(updateMovie, branchid);

		return "success";
	}

	
	public String delete_song() {
		logger.info("Deleting the Song");
		updateSong = new ArrayList<Songs>();
		System.out.println(" size of list" + songlist.size());
		for (Songs data : songlist) {
			if (checked.get(data.getSongid())) {
				System.out.println(data.getQuantity());
				System.out.println(data.getPrice());

				updateSong.add(data);
			}
		}
		int j = updateSong.size();
		Admin admin = new Admin();
		admin.deleteSong(updateSong, branchid);

		return "success";
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

	public int getBranchid() {
		return branchid;
	}

	public Map<Long, Boolean> getChecked() {
		return checked;
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

	public String getmember() {
		System.out.println(" inside the admin");
		logger.info("Getting the member list");
		Admin admin = new Admin();
		member1 = admin.getMemberList();
		return "success";

	}

	public List<Member> getMember1() {
		return member1;
	}

	public String getMovie() {
		Admin admin = new Admin();
		movielist = new ArrayList<Movie>();
		movielist = admin.getAllMovies(branchid);
		return null;
	}

	public List<Movie> getMovielist() {
		return movielist;
	}

	public String getMovieName() {
		return movieName;
	}

	public String getPassword() {
		return password;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public List<Songs> getSong() {
		return song;
	}

	public List<Songs> getSonglist() {
		return songlist;
	}

	public String getSongs() {
		Admin admin = new Admin();
		songlist = new ArrayList<Songs>();
		songlist = admin.getAllSong(branchid);
		return null;
	}

	public List<Movie> getUpdateMovie() {
		return updateMovie;
	}

	public List<Songs> getUpdateSong() {
		return updateSong;
	}

	public String getUserName() {
		return userName;
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

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public void setChecked(Map<Long, Boolean> checked) {
		this.checked = checked;
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

	public void setMember1(List<Member> member1) {
		this.member1 = member1;
	}

	public void setMovielist(List<Movie> movielist) {
		this.movielist = movielist;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setSong(List<Songs> song) {
		this.song = song;
	}

	public void setSonglist(List<Songs> songlist) {
		this.songlist = songlist;
	}

	public void setUpdateMovie(List<Movie> updateMovie) {
		this.updateMovie = updateMovie;
	}

	public void setUpdateSong(List<Songs> updateSong) {
		this.updateSong = updateSong;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String update_Movie() {
		logger.info("Updating Movie");
		System.out.println("  updateing ");
		System.out.println(" in the cart !!!");
		// System.out.println(getQuantity());
		updateMovie = new ArrayList<Movie>();
		System.out.println(" size of list" + movielist.size());
		for (Movie data : movielist) {
			if (checked.get(data.getMovieid())) {
				System.out.println(data.getQuantity());
				System.out.println(data.getPrice());
				updateMovie.add(data);
			}
		}
		int j = updateMovie.size();
		Admin admin = new Admin();
		admin.updateMovie(updateMovie, branchid);
		return "success";
	}

	public String update_Song() {
		logger.info("Updating Song");
		System.out.println("  updateing ");
		System.out.println(" in the cart !!!");
		updateSong = new ArrayList<Songs>();
		System.out.println(" size of list" + songlist.size());
		for (Songs data : songlist) {
			if (checked.get(data.getSongid())) {
				System.out.println(data.getQuantity());
				System.out.println(data.getPrice());
				updateSong.add(data);
			}
		}
		int j = updateSong.size();
		Admin admin = new Admin();
		admin.updateSong(updateSong, branchid);

		return "success";
	}

	
	public String updateInventory() {
		return "updateInventory";
	}

}
