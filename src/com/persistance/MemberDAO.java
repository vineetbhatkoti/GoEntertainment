package com.persistance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.DTO.Member;

public class MemberDAO {
	public String register(String first_name, String last_name, String userid,
			String password, String emailid, String street, String city,
			String state, String country, int zip_code) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JSPProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String q1 = "select c from Member c where c.userid ='" + userid + "'";
		System.out.println(q1);
		Query query1 = em.createQuery(q1);
		List<Member> results = query1.getResultList();
		if (results.size() == 0) {
			String q = "Insert into GoEntertainment.member (first_name,last_name,userid,password,emailid,street,city,state,country,zip_code) values('";
			q += (first_name + "','" + last_name + "','" + userid + "','"
					+ password + "','" + emailid + "','" + street + "','"
					+ city + "','" + state + "','" + country + "'," + zip_code + ");");
			System.out.println(q);
			Query query = em.createNativeQuery(q);

			System.out.println(" in side member");
			query.executeUpdate();
			tx.commit();

			return "registerSuccess";
		} else {
			return "failure";
		}

	}

}
