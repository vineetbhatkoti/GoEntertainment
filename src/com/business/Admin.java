package com.business;

import java.util.List;

import com.DTO.Movie;
import com.DTO.Songs;
import com.persistance.AdminDAO;

public class Admin {
	public void addMovie(Movie song, int branchid) {
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.addMovie(song, branchid);

	}

	public void addSong(Songs song, int branchid) {
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.addSong(song, branchid);

	}

	public String adminAuthenticate(String userName, String password) {
		AdminDAO admin = new AdminDAO();
		return admin.adminAuthenticate(userName, password);
	}

	

	public void deleteMovie(List<Movie> updateMovie, int branchid) {
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.deleteMovie(updateMovie, branchid);
	}

	

	public void deleteSong(List<Songs> updateSong, int branchid) {
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.deleteSong(updateSong, branchid);
	}

	public List<Movie> getAllMovies(int branchid) {
		AdminDAO adminDAO = new AdminDAO();
		return adminDAO.getAllMovies(branchid);

	}

	public List<Songs> getAllSong(int branchid) {
		System.out.println(" getting all songs of branch" + branchid);
		AdminDAO adminDAO = new AdminDAO();
		return adminDAO.getAllSong(branchid);

	}

	public List<com.DTO.Member> getMemberList() {
		AdminDAO admin = new AdminDAO();
		return admin.getMemberList();
	}

	public void updateMovie(List<Movie> updateMovie, int branchid) {
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.updateMovie(updateMovie, branchid);
	}

	public void updateSong(List<Songs> updateSong, int branchid) {
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.updateSong(updateSong, branchid);
	}

	

}
