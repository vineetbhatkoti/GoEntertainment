package com.business;

import com.persistance.MemberDAO;

public class Member {

	public String register(String first_name, String last_name, String userid,
			String password, String emailid, String street, String city,
			String state, String country, int zip_code) {
		MemberDAO memberDAO = new MemberDAO();
		return memberDAO.register(first_name, last_name, userid, password,
				emailid, street, city, state, country, zip_code);

	}

}
