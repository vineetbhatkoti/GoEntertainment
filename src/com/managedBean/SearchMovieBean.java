package com.managedBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.DTO.Movie;
import com.business.Search;

public class SearchMovieBean {
	Logger logger = Logger.getLogger(SearchMovieBean.class);
	String actor;
	int branchid;
	List<Movie> cart;

	private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();

	String genre;

	String language;
	List<Movie> list;
	String medium;

	int memberid;

	String movieName;
	int price;
	int quantity;

	int totalPrice;
	String promo;
	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public SearchMovieBean() {
		super();
	}

	public String addtocart() {
		logger.info("Adding to the cart");
		System.out.println(" in the cart !!!");
		cart = new ArrayList<Movie>();
		System.out.println(" size of list" + list.size());
		for (Movie data : list) {
			if (checked.get(data.getMovieid())) {
				cart.add(data);
			}
		}
		int j = cart.size();
		for (int k = 0; k < j; k++) {
			System.out.println(cart.get(k).getMovieName());
		}
		return "success";
	}

	public String getActor() {
		return actor;
	}

	public int getBranchid() {
		return branchid;
	}

	public List<Movie> getCart() {
		return cart;
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

	public List<Movie> getList() {
		return list;
	}

	public String getMedium() {
		return medium;
	}

	public int getMemberid() {
		return memberid;
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

	public int getTotalPrice() {
		return totalPrice;
	}

	public String orderCart() {
		logger.info("order the cart");
		Search search = new Search();
		int k = cart.size();
		totalPrice = search.orderMovies(cart, memberid, branchid,promo);

		return "success";

	}

	public String reserve() {
		logger.info("Reserving the movie");
		Search search = new Search();
		int k = cart.size();
		totalPrice = search.reserveMovies(cart, memberid, branchid);

		return "success";

	}
	
	public String searchMovie() {
		logger.info("Searching for the movies");
		System.out.println("inside the search");
		Search search = new Search();
		list = search.getMovie(genre, actor, movieName, language, medium,
				branchid);
		return "";

	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public void setCart(List<Movie> cart) {
		this.cart = cart;
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

	public void setList(List<Movie> list) {
		this.list = list;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
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

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
