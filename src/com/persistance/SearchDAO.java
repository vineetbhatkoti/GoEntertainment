package com.persistance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.DTO.Movie;
import com.DTO.Songs;

public class SearchDAO {

	public List<Movie> getMovie(String genre, String actor, String movieName,
			String language, String medium, int branchid) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String q = "SELECT c FROM Movie c where c.branchid=" + branchid;
		if (genre != "") {
			q += ("and c.genre Like " + "'%" + genre + "%'");
		}
		if (actor != "") {
			q += ("and  c.actor Like" + "'%" + actor + "%'");
		}
		if (movieName != "") {
			q += ("and  c.movieName Like" + "'%" + movieName + "%'");
		}
		if (language != "") {
			q += ("and  c.language Like" + "'%" + language + "%'");
		}
		if (medium != "") {
			q += ("and c.medium Like" + "'%" + medium + "%'");
		}
		System.out.println(q);
		Query query = em.createQuery(q);

		System.out.println("After the query ------");
		List<Movie> results = query.getResultList();
		for (Movie c : results) {
			System.out.println(c.getMovieName());
		}

		return results;

	}

	public List<Songs> getSongs(String genre, String artist, String album,
			String language, String medium, int branch) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String q = "SELECT c FROM Songs c where c.branchid=" + branch;

		if (genre != "") {
			q += (" and c.genre Like " + "'%" + genre + "%'");
		}
		if (artist != "") {
			q += (" and c.artist Like" + "'%" + artist + "%'");
		}
		if (album != "") {
			q += (" and c.album Like" + "'%" + album + "%'");
		}
		if (language != "") {
			q += (" and c.language Like" + "'%" + language + "%'");
		}
		if (medium != "") {
			q += (" and c.medium Like" + "'%" + medium + "%'");
		}
		System.out.println(q);
		Query query = em.createQuery(q);

		System.out.println("After the query branch 1 song------");
		List<Songs> results = query.getResultList();
		for (Songs c : results) {
			System.out.println(c.getAlbum());
		}

		return results;

	}

}
