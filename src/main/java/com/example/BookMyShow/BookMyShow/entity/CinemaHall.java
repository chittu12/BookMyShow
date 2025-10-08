package com.example.BookMyShow.BookMyShow.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "cinemahalls"
							  , uniqueConstraints = {
							  
							  @UniqueConstraint(columnNames = {"name","movie_id"}),
							  
							  
							  }
							 )
public class CinemaHall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private int totalseats;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Theater theater;
	
	@JoinColumn(name="movie_id",referencedColumnName = "id")
	@OneToOne(cascade=CascadeType.DETACH)
	private Movie movie;
	


	public CinemaHall(long id, String name, int totalseats, Theater theater, Movie movie, List<Show> show) {
		super();
		this.id = id;
		this.name = name;
		this.totalseats = totalseats;
		this.theater = theater;
		this.movie = movie;
		
	}

	public CinemaHall() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalseats() {
		return totalseats;
	}

	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	
	
	

	
}
