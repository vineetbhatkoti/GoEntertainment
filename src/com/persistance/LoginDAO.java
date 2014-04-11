package com.persistance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.DTO.Member;

public class LoginDAO {

	public int getPass(String name, String password) {

		System.out.println(" calling the persitence");
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		System.out.println("inside the persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String q = "SELECT c FROM Member c where c.userid= " + "'" + name + "'"
				+ "and c.password =" + "'" + password + "'";
		System.out.println(q);
		Query query = em.createQuery(q);
		List<Member> results = query.getResultList();
		tx.commit();
		if (results.size() == 0) {
			System.out.println("size" + results.size());
			return 0;
		} else {
			int memberid = 0;
			for (Member c : results) {
				// System.out.println(c.getUserid());
				// System.out.println(c.getPassword());
				System.out.println(c.getMemberid());
				// System.out.println(c.getFirst_name());
				memberid = c.getMemberid();

			}
			System.out.println(" the memberid variable " + memberid);
			return memberid;

		}

	}

}
