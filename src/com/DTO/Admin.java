package com.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int adminid;
	private String adminName;
	private String password;

	public int getAdminid() {
		return adminid;
	}

	public String getAdminName() {
		return adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
