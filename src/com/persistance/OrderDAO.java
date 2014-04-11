package com.persistance;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.DTO.Movie;
import com.DTO.Songs;
import com.mysql.jdbc.CallableStatement;

public class OrderDAO {

	public int total;

	public int order(List<Songs> order, int memberid, int branchid,String promo) {
		System.out.println(" ----------the member id " + memberid);
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int k = order.size();
		System.out.println("value of k" + k);
		for (int i = 0; i < k; i++) {
			int totalPrice = totalPrice(order.get(i).getQuantity(), order
					.get(i).getPrice());
			
			
			System.out.println("the code :"+promo);
			String code = promo;
			if(promo !=null){
			if(promo.equals("DIS123"))
			{
			BigDecimal  theBalance;
			System.out.println("About to call the Procedure--------");
			Query query1 = em.createNativeQuery("CALL Discount(?)");
			query1.setParameter(1, totalPrice);
			query1.executeUpdate();
			totalPrice= ((BigDecimal)query1.getSingleResult()).intValue(); 
			System.out.println("---------Discounted Price is -----:"+totalPrice);
			}
			}
			
			System.out.println("---------Discounted Price after converting -----:"+totalPrice);
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			String q = "Insert into order_song (quantity,totalPrice,memberid,songid,time) values(";
			q += (order.get(i).getQuantity() + "," + totalPrice + ","
					+ memberid + "," + order.get(i).getSongid() + ",'" + date+ "');");
			System.out.println(q);
			Query query = em.createNativeQuery(q);

			System.out.println(" in side ");
			query.executeUpdate();
			total = totalPrice;
			String a = "Select c from Songs c where c.album ='"
					+ order.get(i).getAlbum() + "'" + "and c.branchid="
					+ branchid;
			Query a1 = em.createQuery(a);
			List<Songs> results = a1.getResultList();
			int revisedSong;
			int song;
			for (Songs c : results) {
				song = c.getQuantity();
				System.out.println("-------------" + c.getQuantity());
				revisedSong = song - (order.get(i).getQuantity());
				System.out.println(" revised song ===" + revisedSong);

				String updateSong = "update Songs set quantity= " + revisedSong
						+ " where album ='" + order.get(i).getAlbum() + "'"
						+ "and language =" + "'" + order.get(i).getLanguage()
						+ "'" + "and branchid=" + branchid;
				Query query12 = em.createNativeQuery(updateSong);
				query12.executeUpdate();
			}

		}
		tx.commit();

		return total;

	}

	
	public int reserve(List<Songs> order, int memberid, int branchid) {
		System.out.println(" ----------the member id ---- Reserverving " + memberid);
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int k = order.size();
		System.out.println("value of k" + k);
		for (int i = 0; i < k; i++) {
			int totalPrice = totalPrice(order.get(i).getQuantity(), order
					.get(i).getPrice());
			total = totalPrice;
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			String q = "Insert into reserve_song (quantity,totalPrice,memberid,songid,time) values(";
			q += (order.get(i).getQuantity() + "," + totalPrice + ","
					+ memberid + "," + order.get(i).getSongid() + ",'" + date+ "');");
			System.out.println(q);
			Query query = em.createNativeQuery(q);

			System.out.println(" in side ");
			query.executeUpdate();
			String a = "Select c from Songs c where c.album ='"
					+ order.get(i).getAlbum() + "'" + "and c.branchid="
					+ branchid+"and c.songid="+order.get(i).getSongid();
			Query a1 = em.createQuery(a);
			List<Songs> results = a1.getResultList();
			int revisedSong;
			int song;
			for (Songs c : results) {
				song = c.getQuantity();
				System.out.println("-------------" + c.getQuantity());
				revisedSong = song - (order.get(i).getQuantity());
				System.out.println(" revised song ===" + revisedSong);

				String updateSong = "update Songs set quantity= " + revisedSong
						+ " where album ='" + order.get(i).getAlbum() + "'"
						+ "and language =" + "'" + order.get(i).getLanguage()
						+ "'" + "and branchid=" + branchid;
				Query query12 = em.createNativeQuery(updateSong);
				query12.executeUpdate();
			}

		}
		tx.commit();

		return total;

	}
	
	public int orderMovies(List<Movie> order, int memberid, int branchid,String promo) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int k = order.size();
		System.out.println("value of k" + k);
		for (int i = 0; i < k; i++) {
			int totalPrice = totalPrice(order.get(i).getQuantity(), order
					.get(i).getPrice());
			
			
			System.out.println("the code :"+promo);
			String code = promo;
			if(promo !=null){
			if(promo.equals("DIS123"))
			{
			System.out.println("About to call the Procedure--------");
			Query query1 = em.createNativeQuery("CALL Discount(?)");
			query1.setParameter(1, totalPrice);
			//query1.setParameter(2, wills);
			query1.executeUpdate();
			totalPrice= ((BigDecimal)query1.getSingleResult()).intValue(); 
			System.out.println("---------Discounted Price is -----:"+totalPrice);
			}
			}
			
			System.out.println("---------Discounted Price after converting -----:"+totalPrice);
			
			
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			String q = "Insert into order_movie (quantity,totalPrice,memberid,movieid,time) values(";
			q += (order.get(i).getQuantity() + "," + totalPrice + ","
					+ memberid + "," + order.get(i).getMovieid() + ",'" + date+ "');");
			System.out.println(q);
			Query query = em.createNativeQuery(q);

			System.out.println(" in side Movies ");
			query.executeUpdate();
			total = totalPrice;
			String a = "Select c from Movie c where c.movieName ='"
					+ order.get(i).getMovieName() + "'" + "and c.branchid="
					+ branchid;
			Query a1 = em.createQuery(a);
			List<Movie> results = a1.getResultList();
			int revisedMovie;
			int movie;
			for (Movie c : results) {
				movie = c.getQuantity();
				System.out.println("-------------" + c.getQuantity());
				revisedMovie = movie - (order.get(i).getQuantity());
				System.out.println(" revised movie ===" + revisedMovie);

				String updateSong = "update Movie set quantity= "
						+ revisedMovie + " where movieName ='"
						+ order.get(i).getMovieName() + "'" + "and language ="
						+ "'" + order.get(i).getLanguage() + "'"
						+ "and branchid=" + branchid;
				Query query12 = em.createNativeQuery(updateSong);
				query12.executeUpdate();
			}

		}
		tx.commit();
		return total;
	}

	public int totalPrice(int quantity, int priceOfEachItem) {
		return quantity * priceOfEachItem;
	}


	public int reserveMovies(List<Movie> cart, int memberid, int branchid) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int k = cart.size();
		System.out.println("value of k" + k);
		for (int i = 0; i < k; i++) {
			int totalPrice = totalPrice(cart.get(i).getQuantity(), cart
					.get(i).getPrice());
			total = totalPrice;
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			String q = "Insert into reserve_movie (quantity,totalPrice,memberid,movieid,time) values(";
			q += (cart.get(i).getGenre() + "','" + cart.get(i).getActor()
					+ "','" + cart.get(i).getMovieName() + "','"
					+ cart.get(i).getLanguage() + "','"
					+ cart.get(i).getMedium() + "',"
					+ cart.get(i).getQuantity() + "," + totalPrice + ","
					+ memberid + "," + cart.get(i).getMovieid() + ",'" + date+ "');");
			System.out.println(q);
			Query query = em.createNativeQuery(q);

			System.out.println(" in side Movies ");
			query.executeUpdate();

			String a = "Select c from Movie c where c.movieName ='"
					+ cart.get(i).getMovieName() + "'" + "and c.branchid="
					+ branchid;
			Query a1 = em.createQuery(a);
			List<Movie> results = a1.getResultList();
			int revisedMovie;
			int movie;
			for (Movie c : results) {
				movie = c.getQuantity();
				System.out.println("-------------" + c.getQuantity());
				revisedMovie = movie - (cart.get(i).getQuantity());
				System.out.println(" revised movie ===" + revisedMovie);

				String updateMovie = "update Movie set quantity= "
						+ revisedMovie + " where movieName ='"
						+ cart.get(i).getMovieName() + "'" + "and language ="
						+ "'" + cart.get(i).getLanguage() + "'"
						+ "and branchid=" + branchid;
				Query query12 = em.createNativeQuery(updateMovie);
				query12.executeUpdate();
			}

		}
		tx.commit();
		return total;
	}

	

}
