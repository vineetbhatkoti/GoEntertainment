package com.business;

import java.util.List;

import com.DTO.Member;
import com.persistance.LoginDAO;
import com.persistance.LoginDAO;

public class Login {

	public int getPass(String name, String password) {
		LoginDAO persistance = new LoginDAO();
		return persistance.getPass(name, password);

	}

}
