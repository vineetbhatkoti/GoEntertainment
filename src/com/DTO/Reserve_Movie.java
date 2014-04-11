package com.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reserve_movie")
public class Reserve_Movie implements Serializable {
	int memberid;

	int movieid;

	int quantity;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int reserveid;

	@Temporal(TemporalType.DATE)
	@Column(name = "Time")
	Date time;

	int totalPrice;

	public int getMemberid() {
		return memberid;
	}

	public int getMovieid() {
		return movieid;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getReserveid() {
		return reserveid;
	}

	public Date getTime() {
		return time;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setReserveid(int reserveid) {
		this.reserveid = reserveid;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
