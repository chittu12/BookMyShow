package com.example.BookMyShow.BookMyShow.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MovieDto {

	
	private Long id;
	
	private String title;
	
	private String description;
	
	private int durationmins;
	
	private String language;
	
	private Date releasedate;
	
	private String country;
	
	private String genre;

	public MovieDto(Long id, String title, String description, int durationmins, String language, Date releasedate,
			String country, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.durationmins = durationmins;
		this.language = language;
		this.releasedate = releasedate;
		this.country = country;
		this.genre = genre;
	}

	public MovieDto() {
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
	
	
}
