package com.example.BookMyShow.BookMyShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.BookMyShow.BookMyShow.entity.Movie;

@Service
public interface MovieService {

public Movie createMovie(Movie movie);

public List<Movie> finadAll();

public Optional<Movie> findById(long id);

public Movie UpdateById(Movie movie);

public String deleteById(long id);

public String deleteAll(Movie movie);

}
