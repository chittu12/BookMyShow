package com.example.BookMyShow.BookMyShow.entity;

import java.time.LocalTime;
import java.util.Date;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "shows"
						  , uniqueConstraints = {
						  
						  @UniqueConstraint(columnNames = {"start_time","cinemahall_id"}),
						  
						  
						  }
						 )
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Date createdon;
	
private LocalTime start_time;

private LocalTime end_date;


@ManyToOne
@JoinColumn(name="cinemahall_id",referencedColumnName = "id")
private CinemaHall cinemaHall;


public Show(long id, Date createdon, LocalTime start_time, LocalTime end_date, CinemaHall cinemaHall) {
	super();
	this.id = id;
	this.createdon = createdon;
	this.start_time = start_time;
	this.end_date = end_date;
	this.cinemaHall = cinemaHall;
}


public Show() {
	super();
	// TODO Auto-generated constructor stub
}


public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


public Date getCreatedon() {
	return createdon;
}


public void setCreatedon(Date createdon) {
	this.createdon = createdon;
}


public LocalTime getStart_time() {
	return start_time;
}


public void setStart_time(LocalTime start_time) {
	this.start_time = start_time;
}


public LocalTime getEnd_date() {
	return end_date;
}


public void setEnd_date(LocalTime end_date) {
	this.end_date = end_date;
}


public CinemaHall getCinemaHall() {
	return cinemaHall;
}


public void setCinemaHall(CinemaHall cinemaHall) {
	this.cinemaHall = cinemaHall;
}
















}
