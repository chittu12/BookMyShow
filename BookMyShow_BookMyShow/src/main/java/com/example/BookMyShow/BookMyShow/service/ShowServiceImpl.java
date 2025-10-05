package com.example.BookMyShow.BookMyShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookMyShow.BookMyShow.entity.Show;
import com.example.BookMyShow.BookMyShow.repository.ShowRepository;

@Service
public class ShowServiceImpl implements ShowService {
	
	@Autowired
	private ShowRepository showRepository;

	@Override
	public Show createMovie(Show show) {
		// TODO Auto-generated method stub
		return showRepository.save(show);
	}

	@Override
	public List<Show> finadAll() {
		// TODO Auto-generated method stub
		return showRepository.findAll();
	}

	@Override
	public Optional<Show> findById(long id) {
		// TODO Auto-generated method stub
		return showRepository.findById(id);
	}

	@Override
	public Show UpdateById(Show show) {
		// TODO Auto-generated method stub
		return showRepository.save(show);
	}

	@Override
	public String deleteById(long id) {
		// TODO Auto-generated method stub
		showRepository.deleteById(id);
		return "Data Deleted Successfully";
	}

	@Override
	public String deleteAll(Show show) {
		// TODO Auto-generated method stub
		showRepository.deleteAll();
		return "All Data Deleted Successfully";
	}

}
