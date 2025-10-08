package com.example.BookMyShow.BookMyShow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShow.BookMyShow.entity.SeatStatus;
import com.example.BookMyShow.BookMyShow.entity.Show;
import com.example.BookMyShow.BookMyShow.entity.ShowSeat;
import com.example.BookMyShow.BookMyShow.projection.ShowSeatProjection;
import com.example.BookMyShow.BookMyShow.repository.ShowRepository;
import com.example.BookMyShow.BookMyShow.repository.ShowSeatRepository;
import com.example.BookMyShow.BookMyShow.service.ShowSeatServiceImpl;
@RestController
@RequestMapping("/api/showseat")
@CrossOrigin(origins = "*")
public class ShowSeatController {
	
	@Autowired
	private ShowSeatServiceImpl showSeatServiceImpl;
	
	@Autowired
	private ShowSeatRepository showSeatRepository;
	
	@Autowired
	private ShowRepository showRepository;

	@PreAuthorize("hasRole('ADMIN')")
@PostMapping("/post")
	
	public ResponseEntity<ShowSeat> createMovie(@RequestBody ShowSeat showSeat) throws Exception
	{
	
		ShowSeat movie1=showSeatServiceImpl.createMovie(showSeat);
		
		return new ResponseEntity<ShowSeat>(movie1,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')" )
	@GetMapping("/get")
	
	public ResponseEntity<List<ShowSeat>> findAll() throws Exception
	{

		
		List<ShowSeat> movie2=showSeatServiceImpl.finadAll();
	

		return new ResponseEntity<List<ShowSeat>>(movie2,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')" )
	@GetMapping("/get/{id}")
	
	public ResponseEntity<ShowSeat> findById(@PathVariable long id)
	{
		Optional<ShowSeat> movie3=showSeatServiceImpl.findById(id);
		if(movie3.isPresent())
		{
			return new ResponseEntity<ShowSeat>(movie3.get(),HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<ShowSeat>(HttpStatus.NOT_FOUND);
		}
	}
	

	
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/put/{id}")
	
	public ResponseEntity<ShowSeat> UpdateById(@PathVariable long id,@RequestBody ShowSeat showSeat)
	{
		ShowSeat movie4=showSeatServiceImpl.UpdateById(showSeat);
		
		movie4.setId(id);
		return new ResponseEntity<ShowSeat>(movie4,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	
	public String deleteById(@PathVariable long id)
	{
		showSeatServiceImpl.deleteById(id);
		
		return "Data Deleted Successfully";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete")
	
	public String deleteAll(@RequestBody ShowSeat showSeat)
	{
		showSeatServiceImpl.deleteAll(showSeat);
		return "All Data Deleted Successfully";
	}
	
	@PostMapping("/generate")
	public ResponseEntity<?> generateSeats(
	        @RequestParam Long showId,
	        @RequestParam int rows,
	        @RequestParam int cols,
	        @RequestParam double price) {

	    Optional<Show> showOpt = showRepository.findById(showId);
	    if (showOpt.isEmpty()) {
	        return ResponseEntity.badRequest().body("Invalid Show ID");
	    }
	    Show show = showOpt.get();
	    List<ShowSeat> existingSeats = showSeatRepository.findByShow(show);

	    Set<String> existingSeatNumbers = existingSeats.stream()
	            .map(ShowSeat::getSeat_no)
	            .collect(Collectors.toSet());
	    
	    

	    List<ShowSeat> seats = new ArrayList();
	    for (int i = 0; i < rows; i++) {
	        char rowLetter = (char) ('A' + i);
	        for (int j = 1; j <= cols; j++) {
	        	if(!existingSeatNumbers.contains(show))
	        	{
	            ShowSeat seat = new ShowSeat();
	            seat.setSeat_no(rowLetter + String.valueOf(j)); // A1, A2, ...
	            seat.setPrice(price);
	            seat.setSeatStatus("Available");
	            seat.setShow(showOpt.get());
	            seats.add(seat);
	        }
	    }
	    }

	    showSeatRepository.saveAll(seats);
	    return ResponseEntity.ok(seats);
	}
	
	
	@GetMapping("/availableseat")
	public ResponseEntity<List<ShowSeat>> findAllAvaialable()
	{
		
		List<ShowSeat> movie2=showSeatRepository.findbySeatstatus();
		
		return new ResponseEntity<List<ShowSeat>>(movie2,HttpStatus.OK);
	}

	
	/*
	 * @PutMapping("/put/cancel")
	 * 
	 * @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<ShowSeat>
	 * cancelSeat(@RequestBody ShowSeat showSeat) {
	 * 
	 * ShowSeat showSeat1=showSeatServiceImpl.cancelSeat(showSeat); return new
	 * ResponseEntity<ShowSeat>(showSeat1,HttpStatus.OK); }
	 * 
	 * @PutMapping("/put/book")
	 * 
	 * @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<ShowSeat>
	 * bookSeat(@RequestBody ShowSeat showSeat) {
	 * 
	 * ShowSeat showSeat2=showSeatServiceImpl.bookSeat(showSeat); return new
	 * ResponseEntity<ShowSeat>(showSeat2,HttpStatus.OK); }
	 * 
	 * @PutMapping("/put/blocked")
	 * 
	 * @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<ShowSeat>
	 * blockedSeat(@RequestBody ShowSeat showSeat) { ShowSeat
	 * showSeat3=showSeatServiceImpl.blockedSeat(showSeat); return new
	 * ResponseEntity<ShowSeat>(showSeat3,HttpStatus.OK); }
	 */
}
