package com.managedBean;

import org.apache.log4j.Logger;

import com.business.Login;
import com.business.Login;

public class LoginBean {
	Logger logger = Logger.getLogger(LoginBean.class);
	int branchid;

	int memberid;
	String message;

	String password;
	String userName;

	public LoginBean() {
		super();
	}

	public String admin() {
		return "admin";
	}

	public int getBranchid() {
		return branchid;
	}

	public int getMemberid() {
		return memberid;
	}

	public String getMessage() {
		return message;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public String nonmember() {
		return "nonMemberSearch";
	}

	public String customerRep() {
		return "customerRep";
	}

	public String authenticate() {
		logger.info("Authenticating the user");
		String j;
		Login login = new Login();
		System.out.println("the name: " + userName);
		System.out.println("the pwd: " + password);
		memberid = login.getPass(userName, password);
		if (memberid == 0) {
			j = "errorMember";

			message = "The UserName or Password is not correct";
			return j;
		}

		return "successMember";
	}

	public String register() {
		return "register";
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
