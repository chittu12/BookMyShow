package com.example.BookMyShow.BookMyShow.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.BookMyShow.BookMyShow.entity.Movie;
import com.example.BookMyShow.BookMyShow.repository.MovieRepository;
import com.example.BookMyShow.BookMyShow.service.MovieServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	private MovieServiceImpl movieServiceImpl;
	
	@Autowired
	
	private MovieRepository movieRepository;
	
	
	 @PreAuthorize("hasRole('ADMIN')") 
	
	  @PostMapping(value= "/post" , consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })
	  
	  public ResponseEntity<Movie> createMovie(@RequestPart ("movie") String movie,@RequestPart ("file") MultipartFile file) throws IOException { 
	
	    ObjectMapper mapper = new ObjectMapper();
	    Movie movie1 = mapper.readValue(movie, Movie.class);
	
	  
	  movie1.setImageData(file.getBytes());
	  
	  movie1=movieServiceImpl.createMovie(movie1);
	  
	  return new ResponseEntity<Movie>(movie1,HttpStatus.CREATED); }
	 
	 
	 @GetMapping("/get/movieimage/{id}")
	 
	 public ResponseEntity<byte[]> getMovieImage(@PathVariable long id)
	 {
		 Movie orElseThrow = movieRepository.findById(id).orElseThrow();
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(orElseThrow.getImageData());
		 
		 
	 }
	

	
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')" )
	@GetMapping("/get")
	
	public ResponseEntity<List<Movie>> findAll()
	{
		List<Movie> movie2=movieServiceImpl.finadAll();
		
		return new ResponseEntity<List<Movie>>(movie2,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')" )
	@GetMapping("/get/{id}")
	
	public ResponseEntity<Movie> findById(@PathVariable long id)
	{
		Optional<Movie> movie3=movieServiceImpl.findById(id);
		if(movie3.isPresent())
		{
			return new ResponseEntity<Movie>(movie3.get(),HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/put/{id}")
	
	public ResponseEntity<Movie> UpdateById(@PathVariable long id,@RequestPart ("movie") String movie,@RequestPart ("file") MultipartFile file) throws IOException
	{
		
		
		  ObjectMapper mapper = new ObjectMapper();
		    Movie movie1 = mapper.readValue(movie, Movie.class);
Movie orElseThrow = movieRepository.findById(id).orElseThrow();


orElseThrow.setTitle(movie1.getTitle());
orElseThrow.setDescription(movie1.getDescription());
orElseThrow.setDurationmins(movie1.getDurationmins());
orElseThrow.setLanguage(movie1.getLanguage());
orElseThrow.setReleasedate(movie1.getReleasedate());
orElseThrow.setCountry(movie1.getCountry());

if (file != null && !file.isEmpty()) {
	orElseThrow.setImageData(file.getBytes());
}
Movie save = movieRepository.save(orElseThrow);

		return new ResponseEntity<Movie>(save,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	
	public String deleteById(@PathVariable long id)
	{
		movieServiceImpl.deleteById(id);
		
		return "Data Deleted Successfully";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete")
	
	public String deleteAll(@RequestBody Movie movie)
	{
		movieServiceImpl.deleteAll(movie);
		return "All Data Deleted Successfully";
	}
	
	@GetMapping("/sort/{field}")
	
	public ResponseEntity<List<Movie>> sortByMovieName(@PathVariable String field)
	{
	List<Movie> movie=movieServiceImpl.sortByMovie(field);
	
	return new ResponseEntity<List<Movie>>(movie,HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	
	public void getExcel(HttpServletResponse response) throws IOException
	{
		response.setContentType("application/octet-stream");
		
		String headerKey="Content-Disposition";
		
		String headerValue="attachment;filename=movie.xls";
		
		response.setHeader(headerKey, headerValue);
		
		movieServiceImpl.createExcel(response);
	}
}
