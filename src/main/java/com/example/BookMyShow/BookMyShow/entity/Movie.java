package com.example.BookMyShow.BookMyShow.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private int durationmins;
	
	private String language;
	

	private Date releasedate;
	
	private String country;
	
	private String genre;
	
	 @Lob
	    @Column(name = "imagedata",length = 1000)
	private byte[] imageData;

	public Movie(Long id, String title, String description, int durationmins, String language, Date releasedate,
			String country, String genre, byte[] imageData) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.durationmins = durationmins;
		this.language = language;
		this.releasedate = releasedate;
		this.country = country;
		this.genre = genre;
		this.imageData = imageData;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationmins() {
		return durationmins;
	}

	public void setDurationmins(int durationmins) {
		this.durationmins = durationmins;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	

	


	
	
}
