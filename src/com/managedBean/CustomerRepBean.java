package com.managedBean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.DTO.Reserve_Movie;
import com.DTO.Reserve_Song;
import com.business.CustRep;


public class CustomerRepBean {
	Logger logger = Logger.getLogger(CustomerRepBean.class);
	public String cusRepName;
	public String password;
	public String message;
	public int customerid;
	int memberid;
	String date1;
	List<Reserve_Movie> reserveMovie;
	public List<Reserve_Movie> getReserveMovie() {
		return reserveMovie;
	}
	public void setReserveMovie(List<Reserve_Movie> reserveMovie) {
		this.reserveMovie = reserveMovie;
	}
	List<Reserve_Song> reservesong;
	public List<Reserve_Song> getReservesong() {
		return reservesong;
	}
	public void setReservesong(List<Reserve_Song> reservesong) {
		this.reservesong = reservesong;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
		
	}
	
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	int branchid;
	public String getCusRepName() {
		return cusRepName;
	}
	public void setCusRepName(String cusRepName) {
		this.cusRepName = cusRepName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBranchid() {
		return branchid;
	}
	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}
	public String CRAuthenticate()
	{
		logger.info(" Authenticating the CR");
		String j;
		CustRep custRep= new CustRep();
		List<com.DTO.Customer_rep> results= custRep.getCRAuthenticate(cusRepName, password);
		for (com.DTO.Customer_rep c : results) {
			// System.out.println(c.getUserid());
			// System.out.println(c.getPassword());
			System.out.println(c.getCusrepid());
			// System.out.println(c.getFirst_name());
			customerid = c.getCusrepid();
			branchid=c.getBranchid();
			
		}
		System.out.println(" the branch id ="+branchid);
		if (branchid == 0) {
			j = "errorCR";

			message = "The UserName or Password is not correct";
			return j;
		}
		else
		{
			j="CRauthenticated";
		}
		return j;
	}
	public String search()
	{
		System.out.println(" in search");
		return "searchCRReserve";
	}

	public String confirmOrder()
	{
		 
		return "confirmorder";
	}
	
	public String getReservedSongOrder() throws ParseException
	{
		logger.info(" Retrieving the reserved song order");
		System.out.println(" Retrieving the order");
		 CustRep custRep=new CustRep();
		 DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date frmDate =sdf.parse(date1);
		 System.out.println("date: "+frmDate);
		  reservesong= custRep.getReserveOrder(memberid,frmDate);
		 return null;
	}
	public String addSongtocart()
	{
		CustRep custRep=new CustRep();
		custRep.addSongtocart(reservesong);
		message="The order is completed.";
		return null;
		
	}
	
	public String getReservedMovieOrder() throws ParseException
	{
		logger.info(" Retrieving the reserved movie order");
		System.out.println(" Retrieving the order for movie");
		 CustRep custRep=new CustRep();
		 DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date frmDate =sdf.parse(date1);
		 System.out.println("date: "+frmDate);
		  reserveMovie= custRep.getReservedMovieOrder(memberid,frmDate);
		 return null;
	}
	
	public String addMovietocart()
	{
		CustRep custRep=new CustRep();
		custRep.addMovietocart(reserveMovie);
		message="The order is completed.";
		return null;
		
	}
	
	public String sendEmail() {		
		final String username = "cr.goentertainment@gmail.com";
		final String password = "crgoentertainment";

		Properties properties = new Properties();
		properties.put("mail.smtp.user", "cr.goentertainment@gmail.com");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "25");
		properties.put("mail.debug", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.EnableSSL.enable", "true");
		properties.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.socketFactory.fallbac k", "false");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.socketFactory.port", "465");

		Session session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			logger.info("-------------- composing message ");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cr.goentertainment@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("vineetbhatkoti@gmail.com"));
			message.setSubject("Restock");
			message.setText("Dear Admin,"
					+ "\n\n This is to inform you that some of the items needs to be restocked.\n Please take necessary action.\n\n Thanks, \n Customer Representative");
			logger.info("-------------- Before Sending mail");
			Transport.send(message);

			logger.info("Message Sent Successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		message="Message Sent Successfully";
		return null;
	}
}
