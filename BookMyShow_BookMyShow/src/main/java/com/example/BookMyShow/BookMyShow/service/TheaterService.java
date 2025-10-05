package com.example.BookMyShow.BookMyShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.BookMyShow.BookMyShow.entity.Theater;

@Service
public interface TheaterService {

	public Theater createMovie(Theater theater);

	public List<Theater> finadAll();

	public Optional<Theater> findById(long id);

	public Theater UpdateById(Theater theater);

	public String deleteById(long id);

	public String deleteAll(Theater theater);
}
