package com.example.BookMyShow.BookMyShow.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BookMyShow.BookMyShow.dto.MovieDto;
import com.example.BookMyShow.BookMyShow.entity.Movie;


@Component
public class MovieMapper {

	@Autowired
	private ModelMapper mapper;
	
	
	public Movie mapToMovie(MovieDto movieDto)
	{
		Movie movie=mapper.map(movieDto,Movie.class);
		return movie;
	}
	
	
	public MovieDto mapToMovieDto(Movie movie)
	{
		MovieDto movieDto=mapper.map(movie,MovieDto .class);
		return movieDto;
	}
}
