package com.persistance;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.DTO.Order_Movie;
import com.DTO.Order_Song;
import com.DTO.Reserve_Movie;
import com.DTO.Reserve_Song;



public class CustRepDAO {
	Logger logger = Logger.getLogger(CustRepDAO.class);
	public List<com.DTO.Customer_rep> CRAuthenticate(String cusRepName, String password) {
		int branchid = 0;
		logger.info(" Authenticating the Customer Representaive");
		System.out.println(" Authenticating the Customer Representaive");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String q = "SELECT c FROM Customer_rep c where c.cusRepName= " + "'" + cusRepName + "'"
				+ "and c.password =" + "'" + password + "'";
		System.out.println(q);
		logger.info(q);
		Query query = em.createQuery(q);
		List<com.DTO.Customer_rep> results = query.getResultList();
		tx.commit();
		if (results.size() == 0) {
			System.out.println("size" + results.size());
			return null;
		} else {
			int customerid = 0;
			for (com.DTO.Customer_rep c : results) {
				// System.out.println(c.getUserid());
				// System.out.println(c.getPassword());
				System.out.println(c.getCusrepid());
				// System.out.println(c.getFirst_name());
				customerid = c.getCusrepid();
				branchid=c.getBranchid();
				
			}

			System.out.println(" the customer representative id   " + customerid);
			return results;

		}

	}

	public List<Reserve_Song> getReserveOrder(int memberid, Date date) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		logger.info("Reserving the song");
		System.out.println("DAte befoe qery:"+date);
		Query query = em.createQuery("SELECT c FROM Reserve_Song c where c.memberid= :memberid and c.time = :date");
		query.setParameter("date", date);
		query.setParameter("memberid", memberid);
		System.out.println("query :"+query);
		List<Reserve_Song> results = query.getResultList();
		tx.commit();
		for (Reserve_Song c : results) {
			System.out.println(c.getQuantity());
			System.out.println(c.getTotalPrice());
			
			
		}
		return results;
	}

	public void addSongtocart(List<Reserve_Song> reserveMovie)  {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		logger.info("Ordering the song");
		int k = reserveMovie.size();
		System.out.println("value of k" + k);
		for (int i = 0; i < k; i++) {
			
			Date date=reserveMovie.get(i).getTime();
			System.out.println(date);
			Order_Song order=new Order_Song();
			order.setMemberid(reserveMovie.get(i).getMemberid());
			order.setQuantity(reserveMovie.get(i).getQuantity());
			order.setTime(reserveMovie.get(i).getTime());
			order.setTotalPrice(reserveMovie.get(i).getTotalPrice());
			order.setSongid(reserveMovie.get(i).getSongid());
			System.out.println("Before persisting"+order.getQuantity());
			em.persist(order);
		System.out.println(" Inserted into Order_song");
		String updateSong = "Delete from reserve_song where  reserveid= " + reserveMovie.get(i).getReserveid();
		Query query12 = em.createNativeQuery(updateSong);
		query12.executeUpdate();
		System.out.println(" Successfully removed from reserve_song");
	}
		tx.commit();
	}

	public List<Reserve_Movie> getReservedMovieOrder(int memberid, Date frmDate) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		logger.info("Getting the order");
		System.out.println("DAte befoe qery:"+frmDate);
		Query query = em.createQuery("SELECT c FROM Reserve_Movie c where c.memberid= :memberid and c.time = :date");
		query.setParameter("date", frmDate);
		query.setParameter("memberid", memberid);
		System.out.println("query :"+query);
		List<Reserve_Movie> results = query.getResultList();
		tx.commit();
		for (Reserve_Movie c : results) {
			System.out.println(c.getQuantity());
			System.out.println(c.getTotalPrice());
			
		}
		return results;
	}

	public void addMovietocart(List<Reserve_Movie> reserveMovie) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		logger.info("ordering movie");
		int k = reserveMovie.size();
		System.out.println("value of k" + k);
		for (int i = 0; i < k; i++) {
			
			Date date=reserveMovie.get(i).getTime();
			System.out.println(date);
			Order_Movie order=new Order_Movie();
			
			
			order.setMemberid(reserveMovie.get(i).getMemberid());
			order.setQuantity(reserveMovie.get(i).getQuantity());
			order.setTime(reserveMovie.get(i).getTime());
			order.setTotalPrice(reserveMovie.get(i).getTotalPrice());
			order.setMovieid(reserveMovie.get(i).getMovieid());
			
			System.out.println("Before persisting"+order.getQuantity());
			em.persist(order);
			System.out.println(" Inserted into Order_movie");
			String updateMovie = "Delete from reserve_movie where  reserveid= " + reserveMovie.get(i).getReserveid();
			Query query12 = em.createNativeQuery(updateMovie);
			query12.executeUpdate();
			System.out.println(" Successfully removed from reserve_movie");
		}
			tx.commit();
	}

	
}
