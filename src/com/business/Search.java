package com.business;

import java.util.List;

import com.DTO.Movie;
import com.DTO.Songs;
import com.persistance.OrderDAO;
import com.persistance.SearchDAO;

public class Search {

	public List<Movie> getMovie(String genre, String actor, String movieName,
			String language, String medium, int branchid) {
		SearchDAO searchDAO = new SearchDAO();
		System.out.println(" in the Search - getMovie()");
		return searchDAO.getMovie(genre, actor, movieName, language, medium,
				branchid);
	}

	public List<Songs> getSongs(String genre, String artist, String album,
			String language, String medium, int branch) {
		SearchDAO searchDAO = new SearchDAO();
		System.out.println(" in the Search - songs");
		return searchDAO.getSongs(genre, artist, album, language, medium,
				branch);

	}

	public int order(List<Songs> order, int memberid, int branchid,String promo) {
		OrderDAO orderDAO = new OrderDAO();
		System.out.println(" in the Search - order()");
		return orderDAO.order(order, memberid, branchid,promo);
	}
	
	public int reserve(List<Songs> order, int memberid, int branchid) {
		OrderDAO orderDAO = new OrderDAO();
		System.out.println(" in the Search - order()");
		return orderDAO.reserve(order, memberid, branchid);
	}

	public int orderMovies(List<Movie> order, int memberid, int branchid,String promo) {
		OrderDAO orderDAO = new OrderDAO();
		System.out.println(" in the Search - orderMovies()");
		return orderDAO.orderMovies(order, memberid, branchid,promo);
	}

	public int reserveMovies(List<Movie> cart, int memberid, int branchid) {
		OrderDAO orderDAO = new OrderDAO();
		System.out.println(" in the Search - order()");
		return orderDAO.reserveMovies(cart, memberid, branchid);
	}

}
