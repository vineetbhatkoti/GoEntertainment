package com.persistance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.DTO.Admin;
import com.DTO.Member;
import com.DTO.Movie;
import com.DTO.Songs;
import com.managedBean.SearchSongBean;

public class AdminDAO {
	Logger logger = Logger.getLogger(AdminDAO.class);
	public void addMovie(Movie song, int branchid) {
		logger.info("Adding Movies ");
		System.out.println(" calling the persitence");
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		System.out.println("inside the persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			String q = "Insert into Movie (genre,actor,movieName,language,medium,quantity,Price,branchid) values('";
			q += (song.getGenre() + "','" + song.getActor() + "','"
					+ song.getMovieName() + "','" + song.getLanguage() + "','"
					+ song.getMedium() + "'," + song.getQuantity() + ","
					+ song.getPrice() + "," + branchid + ");");
			System.out.println(q);
			logger.info(q);
			Query query = em.createNativeQuery(q);

			System.out.println(" in side movie ");
			query.executeUpdate();

		}
		System.out.println(" before commmiting ");
		tx.commit();
	}

	public void addSong(Songs song, int branchid) {
		logger.info("Adding songs ");
		System.out.println(" calling the persitence");
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		System.out.println("inside the persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			String q = "Insert into songs (genre,artist,album,language,medium,quantity,Price,branchid) values('";
			q += (song.getGenre() + "','" + song.getArtist() + "','"
					+ song.getAlbum() + "','" + song.getLanguage() + "','"
					+ song.getMedium() + "'," + song.getQuantity() + ","
					+ song.getPrice() + "," + branchid + ");");
			System.out.println(q);
			logger.info(q);
			Query query = em.createNativeQuery(q);

			System.out.println(" in side song ");
			query.executeUpdate();

		}
		System.out.println(" before commmiting ");
		tx.commit();
	}

	public String adminAuthenticate(String userName, String password) {
		logger.info("Authenticating the admin ");
		System.out.println(" calling the persitence");
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		System.out.println("inside the persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String q = "SELECT c FROM Admin c where c.adminName= " + "'" + userName
				+ "'" + "and c.password =" + "'" + password + "'";
		System.out.println(q);
		logger.info(q);
		Query query = em.createQuery(q);
		List<Admin> results = query.getResultList();
		tx.commit();
		if (results.size() == 0) {
			System.out.println("size" + results.size());
			return "adminFail";
		} else {
			int adminid = 0;
			for (Admin c : results) {
				System.out.println(c.getAdminid());
				adminid = c.getAdminid();

			}

			System.out.println(" the memberid variable " + adminid);
			return "adminSuccess";

		}
	}



	public void deleteMovie(List<Movie> updateMovie, int branchid) {
		logger.info("Deleting the movie");
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		System.out.println("inside the persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		for (Movie c : updateMovie) {
			System.out.println("-------------" + c.getQuantity());
			System.out.println("-------------" + c.getPrice());
			System.out.println(" --------------" + c.getMovieName());
			String a = "Delete From Movie  where movieName ='"
					+ c.getMovieName() + "'" + "and language =" + "'"
					+ c.getLanguage() + "'" + "and branchid =" + branchid;
			logger.info(a);
			Query query12 = em.createNativeQuery(a);
			query12.executeUpdate();

		}
		tx.commit();

	}

	

	public void deleteSong(List<Songs> updateSong, int branchid) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		logger.info("Deleting the songs");
		System.out.println("inside the persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		for (Songs c : updateSong) {
			System.out.println("-------------" + c.getQuantity());
			System.out.println("-------------" + c.getPrice());
			System.out.println(" --------------" + c.getAlbum());
			String a = "Delete From Songs  where album ='" + c.getAlbum() + "'"
					+ "and language =" + "'" + c.getLanguage() + "'"
					+ "and branchid =" + branchid;
			logger.info(a);
			Query query12 = em.createNativeQuery(a);
			query12.executeUpdate();

		}
		tx.commit();
	}

	public List<Movie> getAllMovies(int branchid) {
		logger.info("Getting the movie");
		System.out.println(" calling the persitence");
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		System.out.println("inside the persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String q = "SELECT c FROM Movie c where c.branchid=" + branchid;
		System.out.println(q);
		logger.info(q);
		Query query = em.createQuery(q);
		List<Movie> results = query.getResultList();
		tx.commit();
		for (Movie c : results) {
			System.out.println(c.getMovieName());
		}

		return results;
	}

	public List<Songs> getAllSong(int branchid) {
		logger.info("Getting the songs");
		System.out.println(" calling the persitence");
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		System.out.println("inside the persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String q = "SELECT c FROM Songs c where c.branchid=" + branchid;
		logger.info(q);
		System.out.println(q);
		Query query = em.createQuery(q);
		List<Songs> results = query.getResultList();
		tx.commit();
		for (Songs c : results) {
			System.out.println(c.getAlbum());
		}

		return results;

	}

	public List<Member> getMemberList() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		logger.info("Getting member list");
		String q1 = "select c from Member c ";
		System.out.println(q1);
		logger.info(q1);
		Query query1 = em.createQuery(q1);
		List<Member> results = query1.getResultList();
		for (Member member : results) {
			System.out.println(member.getMemberid());
		}
		return results;
	}

	public void updateMovie(List<Movie> updateMovie, int branchid) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		System.out.println("inside the persistence");
		logger.info("Updating the movie");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		for (Movie c : updateMovie) {
			System.out.println("-------------" + c.getQuantity());
			System.out.println("-------------" + c.getPrice());
			System.out.println(" --------------" + c.getMovieName());

			String a = "update Movie set quantity= " + c.getQuantity() + ","
					+ "price=" + c.getPrice() + " where movieName ='"
					+ c.getMovieName() + "'" + "and language =" + "'"
					+ c.getLanguage() + "'" + "and branchid =" + branchid;
			logger.info(a);
			Query query12 = em.createNativeQuery(a);
			query12.executeUpdate();

		}
		tx.commit();

	}

	public void updateSong(List<Songs> updateSong, int branchid) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		System.out.println("inside the persistence");
		logger.info("Updating the song");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		for (Songs c : updateSong) {
			System.out.println("-------------" + c.getQuantity());
			System.out.println("-------------" + c.getPrice());
			System.out.println(" --------------" + c.getAlbum());

			String a = "update Songs set quantity= " + c.getQuantity() + ","
					+ "price=" + c.getPrice() + " where album ='"
					+ c.getAlbum() + "'" + "and language =" + "'"
					+ c.getLanguage() + "'" + "and branchid =" + branchid;
			logger.info(a);
			Query query12 = em.createNativeQuery(a);
			query12.executeUpdate();

		}
		tx.commit();

	}

}
