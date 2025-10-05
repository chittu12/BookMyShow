package com.example.BookMyShow.BookMyShow.service;

import java.util.List;
import java.util.Optional;

import com.example.BookMyShow.BookMyShow.entity.Booking;
import com.example.BookMyShow.BookMyShow.entity.User;


public interface BookingService {
	
	public Booking createMovie(Booking booking);

	public List<Booking> finadAll();

	public List<Booking> findById(User user);

	public Booking UpdateById(Booking booking);

	public String deleteById(long id);

	public String deleteAll(Booking booking);
	
	 public Booking calculateTotalCost(long id); 

}
