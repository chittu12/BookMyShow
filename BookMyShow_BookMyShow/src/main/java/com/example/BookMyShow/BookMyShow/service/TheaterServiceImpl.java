package com.example.BookMyShow.BookMyShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookMyShow.BookMyShow.entity.Theater;
import com.example.BookMyShow.BookMyShow.repository.TheaterRepository;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private TheaterRepository theaterRepository;
	
	@Override
	public Theater createMovie(Theater theater) {
		// TODO Auto-generated method stub
		return theaterRepository.save(theater);
	}

	@Override
	public List<Theater> finadAll() {
		// TODO Auto-generated method stub
		return theaterRepository.findAll();
	}

	@Override
	public Optional<Theater> findById(long id) {
		// TODO Auto-generated method stub
		return theaterRepository.findById(id);
	}

	@Override
	public Theater UpdateById(Theater theater) {
		// TODO Auto-generated method stub
		return theaterRepository.save(theater);
	}

	@Override
	public String deleteById(long id) {
		// TODO Auto-generated method stub
		theaterRepository.deleteById(id);
		return "Data Deleted Successfully";
	}

	@Override
	public String deleteAll(Theater theater) {
		// TODO Auto-generated method stub
		theaterRepository.deleteAll();
		return "All Data Deleted Successfully";
	}

}
