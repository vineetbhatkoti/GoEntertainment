package com.managedBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.DTO.Order;
import com.DTO.Songs;
import com.business.Search;

public class SearchSongBean {
	Logger logger = Logger.getLogger(SearchSongBean.class);
	String album;
	String artist;
	int branchid;

	List<Songs> cart;

	private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();

	String genre;
	String language;
	List<Songs> list;
	String medium;
	int memberid;
	List<Order> order;

	int price;
	int quant;
	boolean select;

	int totalPrice;

	int value;
	String promo;

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public SearchSongBean() {
		super();
	}

	public String addtocart() {
		logger.info(" Adding the songs to the cart");
		System.out.println(" in the cart !!!");
		// System.out.println(getQuantity());
		cart = new ArrayList<Songs>();
		System.out.println(" size of list" + list.size());
		for (Songs data : list) {
			if (checked.get(data.getSongid())) {
				System.out.println(data.getQuantity());
				
				cart.add(data);
			}
		}
		int j = cart.size();
		for (int k = 0; k < j; k++) {
			System.out.println(cart.get(k).getAlbum());
		}
		return "success";
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

	public List<Songs> getCart() {
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

	public List<Songs> getList() {
		return list;
	}

	public String getMedium() {
		return medium;
	}

	public int getMemberid() {
		return memberid;
	}

	public List<Order> getOrder() {
		return order;
	}

	public int getPrice() {
		return price;
	}

	public int getQuant() {
		return quant;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public int getValue() {
		return value;
	}

	public boolean isSelect() {
		return select;
	}

	public String orderCart() {
		logger.info("Ordering the songs");
		Search search = new Search();
		int k = cart.size();
		totalPrice = search.order(cart, memberid, branchid,promo);

		return "success";

	}

	public String reserve() {
		logger.info("reserving the songs");
		Search search = new Search();
		int k = cart.size();
		System.out.println("memberid: "+memberid);
		totalPrice = search.reserve(cart, memberid, branchid);

		return "success";

	}
	
	public String search() {
		logger.info("Searching for the songs");
		System.out.println("inside the search");
		System.out.println("memberid ---" + memberid);

		Search search = new Search();
		list = search
				.getSongs(genre, artist, album, language, medium, branchid);
		return "";

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

	public void setCart(List<Songs> cart) {
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

	public void setList(List<Songs> list) {
		this.list = list;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
