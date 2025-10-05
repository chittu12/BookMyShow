package com.example.BookMyShow.BookMyShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookMyShow.BookMyShow.entity.CinemaHall;
import com.example.BookMyShow.BookMyShow.repository.CinemaHallRepository;
@Service
public class CinemaHallServiceImpl implements CinemaHallService {
	
	@Autowired
	private CinemaHallRepository cinemaHallRepository;

	@Override
	public CinemaHall createMovie(CinemaHall cinemaHall) {
		// TODO Auto-generated method stub
		return cinemaHallRepository.save(cinemaHall);
	}

	@Override
	public List<CinemaHall> finadAll() {
		// TODO Auto-generated method stub
		return cinemaHallRepository.findAll();
	}

	@Override
	public Optional<CinemaHall> findById(long id) {
		// TODO Auto-generated method stub
		return cinemaHallRepository.findById(id);
	}

	@Override
	public CinemaHall UpdateById(CinemaHall cinemaHall) {
		// TODO Auto-generated method stub
		return cinemaHallRepository.save(cinemaHall);
	}

	@Override
	public String deleteById(long id) {
		cinemaHallRepository.deleteById(id);
		return "Data Deleted Successfully";
	}

	@Override
	public String deleteAll(CinemaHall cinemaHall) {
		cinemaHallRepository.deleteAll();
		return "All Data Deleted Successfully";
	}

}
