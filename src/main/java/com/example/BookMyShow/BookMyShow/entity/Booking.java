package com.example.BookMyShow.BookMyShow.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Date booking_date;
	
	private String transaction_mode;
	
	private String transaction_status;
	
	private double total_cost;
	
	private String seatstatus;


	
	@PrePersist
	private void onCreate() {
		booking_date = new Date();
	}
	
	
	@OneToOne(cascade = CascadeType.DETACH)
	private Show show;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private User user;
	
	@OneToMany
	private Set<ShowSeat> showSeat;



	public Booking(long id, Date booking_date, String transaction_mode, String transaction_status, double total_cost,
			String seatstatus, Show show, User user, Set<ShowSeat> showSeat) {
		super();
		this.id = id;
		this.booking_date = booking_date;
		this.transaction_mode = transaction_mode;
		this.transaction_status = transaction_status;
		this.total_cost = total_cost;
		this.seatstatus = seatstatus;
		this.show = show;
		this.user = user;
		this.showSeat = showSeat;
	}



	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Date getBooking_date() {
		return booking_date;
	}



	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}



	public String getTransaction_mode() {
		return transaction_mode;
	}



	public void setTransaction_mode(String transaction_mode) {
		this.transaction_mode = transaction_mode;
	}



	public String getTransaction_status() {
		return transaction_status;
	}



	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}



	public double getTotal_cost() {
		return total_cost;
	}



	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}



	public String getSeatstatus() {
		return seatstatus;
	}



	public void setSeatstatus(String seatstatus) {
		this.seatstatus = seatstatus;
	}



	public Show getShow() {
		return show;
	}



	public void setShow(Show show) {
		this.show = show;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Set<ShowSeat> getShowSeat() {
		return showSeat;
	}



	public void setShowSeat(Set<ShowSeat> showSeat) {
		this.showSeat = showSeat;
	}



	








	
	


	


	
	
	
	
	
	
	
	
	

}
