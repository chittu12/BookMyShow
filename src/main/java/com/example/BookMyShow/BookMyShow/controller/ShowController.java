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

import com.example.BookMyShow.BookMyShow.entity.Movie;
import com.example.BookMyShow.BookMyShow.entity.Show;
import com.example.BookMyShow.BookMyShow.repository.ShowSeatRepository;
import com.example.BookMyShow.BookMyShow.service.ShowServiceImpl;

@RestController
@RequestMapping("/api/show")
public class ShowController {

	@Autowired
	private ShowServiceImpl showServiceImpl;
	
	@Autowired
	private ShowSeatRepository showSeatRepository;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/post")
	
	public ResponseEntity<Show> createMovie(@RequestBody Show show)
	{
		Show movie1=showServiceImpl.createMovie(show);
		
		return new ResponseEntity<Show>(movie1,HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')" )
	@GetMapping("/get")
	
	public ResponseEntity<List<Show>> findAll()
	{
		List<Show> movie2=showServiceImpl.finadAll();
		
		return new ResponseEntity<List<Show>>(movie2,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')" )
	@GetMapping("/get/{id}")
	
	public ResponseEntity<Show> findById(@PathVariable long id)
	{
		Optional<Show> movie3=showServiceImpl.findById(id);
		if(movie3.isPresent())
		{
			return new ResponseEntity<Show>(movie3.get(),HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<Show>(HttpStatus.NOT_FOUND);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/put/{id}")
	
	public ResponseEntity<Show> UpdateById(@PathVariable long id,@RequestBody Show show)
	{
		Show movie4=showServiceImpl.UpdateById(show);
		
		movie4.setId(id);
		return new ResponseEntity<Show>(movie4,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	
	public String deleteById(@PathVariable long id)
	{
		showServiceImpl.deleteById(id);
		
		return "Data Deleted Successfully";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete")
	
	public String deleteAll(@RequestBody Show show)
	{
		showServiceImpl.deleteAll(show);
		return "All Data Deleted Successfully";
	}

}
