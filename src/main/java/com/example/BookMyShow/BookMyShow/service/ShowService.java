package com.example.BookMyShow.BookMyShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.BookMyShow.BookMyShow.entity.Show;
@Service
public interface ShowService {

	public Show createMovie(Show show);

	public List<Show> finadAll();

	public Optional<Show> findById(long id);

	public Show UpdateById(Show show);

	public String deleteById(long id);

	public String deleteAll(Show show);
}
