package com.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member implements Serializable {
	String city;

	String country;

	String emailid;

	String first_name;
	String last_name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int memberid;
	String password;
	String state;
	String street;
	String userid;
	int zip_code;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int memberid, String first_name, String last_name,
			String userid, String password, String emailid, String street,
			String city, String state, String country, int zip_code) {
		super();
		this.memberid = memberid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.userid = userid;
		this.password = password;
		this.emailid = emailid;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip_code = zip_code;
	}

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

	public int getMemberid() {
		return memberid;
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

	public void setMemberid(int memberid) {
		this.memberid = memberid;
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

}
