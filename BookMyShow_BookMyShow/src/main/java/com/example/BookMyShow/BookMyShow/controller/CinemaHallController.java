package com.example.BookMyShow.BookMyShow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShow.BookMyShow.entity.CinemaHall;

import com.example.BookMyShow.BookMyShow.service.CinemaHallServiceImpl;

@RestController
@RequestMapping("/api/cinema")
public class CinemaHallController {
	
	@Autowired
	private CinemaHallServiceImpl cinemaHallServiceImpl;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/post")
	
	public ResponseEntity<CinemaHall> createMovie(@RequestBody CinemaHall cinemaHall)
	{
		CinemaHall movie1=cinemaHallServiceImpl.createMovie(cinemaHall);
		
		return new ResponseEntity<CinemaHall>(movie1,HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')" )
	@GetMapping("/get")
	
	public ResponseEntity<List<CinemaHall>> findAll()
	{
		List<CinemaHall> movie2=cinemaHallServiceImpl.finadAll();
		
		return new ResponseEntity<List<CinemaHall>>(movie2,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')" )
	@GetMapping("/get/{id}")
	
	public ResponseEntity<CinemaHall> findById(@PathVariable long id)
	{
		Optional<CinemaHall> movie3=cinemaHallServiceImpl.findById(id);
		if(movie3.isPresent())
		{
			return new ResponseEntity<CinemaHall>(movie3.get(),HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<CinemaHall>(HttpStatus.NOT_FOUND);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/put/{id}")
	
	public ResponseEntity<CinemaHall> UpdateById(@PathVariable long id,@RequestBody CinemaHall cinemaHall)
	{
		CinemaHall movie4=cinemaHallServiceImpl.UpdateById(cinemaHall);
		
		movie4.setId(id);
		return new ResponseEntity<CinemaHall>(movie4,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	
	public String deleteById(@PathVariable long id)
	{
		cinemaHallServiceImpl.deleteById(id);
		
		return "Data Deleted Successfully";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete")
	
	public String deleteAll(@RequestBody CinemaHall cinemaHall)
	{
		cinemaHallServiceImpl.deleteAll(cinemaHall);
		return "All Data Deleted Successfully";
	}
}
