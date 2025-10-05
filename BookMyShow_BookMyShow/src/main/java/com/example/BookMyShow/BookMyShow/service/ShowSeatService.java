package com.example.BookMyShow.BookMyShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.BookMyShow.BookMyShow.entity.Show;
import com.example.BookMyShow.BookMyShow.entity.ShowSeat;
@Service
public interface ShowSeatService {

	public ShowSeat createMovie(ShowSeat showSeat) throws Exception;

	public List<ShowSeat> finadAll() throws Exception;

	public Optional<ShowSeat> findById(long id);

	public ShowSeat UpdateById(ShowSeat showSeat);

	public String deleteById(long id);

	public String deleteAll(ShowSeat showSeat);
	

	
	/*
	 * public ShowSeat cancelSeat(ShowSeat showSeat);
	 * 
	 * public ShowSeat bookSeat(ShowSeat showSeat);
	 * 
	 * public ShowSeat blockedSeat(ShowSeat showSeat);
	 */
}
