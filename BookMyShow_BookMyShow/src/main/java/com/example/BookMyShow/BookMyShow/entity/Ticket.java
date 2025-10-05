package com.example.BookMyShow.BookMyShow.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="tickets",uniqueConstraints = {
		 
		  @UniqueConstraint(columnNames = {"bookingnumber","booking_id"}),
		 
		 })
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String bookingnumber;
	
	private int numberofseats;
	
	private Date createdon;
	
	private double total_cost;
	

	

	

	

	

	
	
	@OneToOne(cascade=CascadeType.DETACH)
	

	private Booking booking;
	

	
	

	@PrePersist
	private void onCreate() {
		createdon = new Date();
	}



	public Ticket(long id, String bookingnumber, int numberofseats, Date createdon, Booking booking,
			Set<ShowSeat> showSeat,double total_cost) {
		super();
		this.id = id;
		this.bookingnumber = bookingnumber;
		this.numberofseats = numberofseats;
		this.createdon = createdon;
		this.booking = booking;
this.total_cost=total_cost;
	}



	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getBookingnumber() {
		return bookingnumber;
	}



	public void setBookingnumber(String bookingnumber) {
		this.bookingnumber = bookingnumber;
	}



	public int getNumberofseats() {
		return numberofseats;
	}



	public void setNumberofseats(int numberofseats) {
		this.numberofseats = numberofseats;
	}



	public Date getCreatedon() {
		return createdon;
	}



	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}



	public Booking getBooking() {
		return booking;
	}



	public void setBooking(Booking booking) {
		this.booking = booking;
	}



	public double getTotal_cost() {
		return total_cost;
	}



	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}










	



















	


	

	
	
	


	

	

	


	
	
	
	
}
