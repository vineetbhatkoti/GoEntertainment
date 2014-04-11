package com.managedBean;

import org.apache.log4j.Logger;

import com.business.Member;

public class RegisterBean {
	Logger logger = Logger.getLogger(RegisterBean.class);
	String city;
	String country;
	String emailid;
	String first_name;
	String last_name;
	String password;
	String state;
	String street;
	String userid;
	int zip_code;

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getEmailid() {
		return emailid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getPassword() {
		return password;
	}

	public String getState() {
		return state;
	}

	public String getStreet() {
		return street;
	}

	public String getUserid() {
		return userid;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public String submit_final() {
		logger.info("Registering the new user");
		Member member = new Member();
		String msg = member.register(first_name, last_name, userid, password,
				emailid, street, city, state, country, zip_code);
		return msg;
	}
}
