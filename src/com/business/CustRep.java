package com.business;

import java.util.Date;
import java.util.List;

import com.DTO.Reserve_Movie;
import com.DTO.Reserve_Song;
import com.persistance.CustRepDAO;

public class CustRep {

	public List<com.DTO.Customer_rep> getCRAuthenticate(String cusRepName, String password) {
		CustRepDAO custRepDAO=new CustRepDAO();
		return custRepDAO.CRAuthenticate(cusRepName,password);
	}

	public List<Reserve_Song> getReserveOrder(int memberid, Date date) {
		CustRepDAO custRepDAO=new CustRepDAO();
	 return	 custRepDAO.getReserveOrder(memberid,date);
	}

	public void addSongtocart(List<Reserve_Song> reservesong) {
		CustRepDAO custRepDAO=new CustRepDAO();
		custRepDAO.addSongtocart(reservesong);
	}

	public List<Reserve_Movie> getReservedMovieOrder(int memberid, Date frmDate) {
		CustRepDAO custRepDAO=new CustRepDAO();
		 return	 custRepDAO.getReservedMovieOrder(memberid,frmDate);
	}

	public void addMovietocart(List<Reserve_Movie> reserveMovie) {
		CustRepDAO custRepDAO=new CustRepDAO();
		custRepDAO.addMovietocart(reserveMovie);
	}

}
