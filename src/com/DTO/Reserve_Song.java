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
@Table(name = "reserve_song")
public class Reserve_Song implements Serializable {
	int memberid;

	int quantity;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int reserveid;
	int songid;
	@Temporal(TemporalType.DATE)
	@Column(name = "Time")
	Date time;

	int totalPrice;

	public int getMemberid() {
		return memberid;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getReserveid() {
		return reserveid;
	}

	public int getSongid() {
		return songid;
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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setReserveid(int reserveid) {
		this.reserveid = reserveid;
	}

	public void setSongid(int songid) {
		this.songid = songid;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
