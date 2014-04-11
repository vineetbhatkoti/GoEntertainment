package com.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_rep")
public class Customer_rep implements Serializable {
	int branchid;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cusrepid;

	String cusRepName;

	String password;
	public int getBranchid() {
		return branchid;
	}
	public int getCusrepid() {
		return cusrepid;
	}

	public String getCusRepName() {
		return cusRepName;
	}

	public String getPassword() {
		return password;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public void setCusrepid(int cusrepid) {
		this.cusrepid = cusrepid;
	}

	public void setCusRepName(String cusRepName) {
		this.cusRepName = cusRepName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
