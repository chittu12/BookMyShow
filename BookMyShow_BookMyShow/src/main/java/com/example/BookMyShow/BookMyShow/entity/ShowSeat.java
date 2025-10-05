package com.example.BookMyShow.BookMyShow.entity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "showseats"/*
							 * , uniqueConstraints = {
							 * 
							 * @UniqueConstraint(columnNames = {"seat_no","show_id"}),
							 * 
							 * 
							 * }
							 */)
public class ShowSeat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String seat_no;
	
	private double price;
	

	
	
	private String seatStatus;
	
	

	@ManyToOne

	private Show show;


	public ShowSeat(long id, String seat_no, double price, String seatStatus, Show show) {
		super();
		this.id = id;
		this.seat_no = seat_no;
		this.price = price;
		this.seatStatus = seatStatus;
		this.show = show;
	}


	public ShowSeat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getSeat_no() {
		return seat_no;
	}


	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getSeatStatus() {
		return seatStatus;
	}


	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}


	public Show getShow() {
		return show;
	}


	public void setShow(Show show) {
		this.show = show;
	}

	

	
	
	
	

	
	
	
	
	
	

	
	
	
	
}
