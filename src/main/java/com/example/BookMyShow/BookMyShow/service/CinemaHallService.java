package com.example.BookMyShow.BookMyShow.service;

import java.util.List;
import java.util.Optional;

import com.example.BookMyShow.BookMyShow.entity.CinemaHall;


public interface CinemaHallService{
	public CinemaHall createMovie(CinemaHall cinemaHall);

	public List<CinemaHall> finadAll();

	public Optional<CinemaHall> findById(long id);

	public CinemaHall UpdateById(CinemaHall cinemaHall);

	public String deleteById(long id);

	public String deleteAll(CinemaHall cinemaHall);
	
}
