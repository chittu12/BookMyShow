package com.example.BookMyShow.BookMyShow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookMyShow.BookMyShow.entity.SeatStatus;
import com.example.BookMyShow.BookMyShow.entity.Show;
import com.example.BookMyShow.BookMyShow.entity.ShowSeat;
import com.example.BookMyShow.BookMyShow.repository.ShowSeatRepository;
@Service
public class ShowSeatServiceImpl implements ShowSeatService {
	
	@Autowired
	private ShowSeatRepository showSeatRepository;

	@Override
	public ShowSeat createMovie(ShowSeat showSeat) throws Exception {
		// TODO Auto-generated method stub
		if(showSeat != null)
		{
			if(showSeatRepository.existsById(showSeat.getId()))
			{
			throw new Exception("Seat already exist");
			}
			else
			{
				showSeatRepository.saveAndFlush(showSeat);
			}
		}
		
		
		
		
		

	
		
		return showSeatRepository.getOne(showSeat.getId());
	}

	@Override
	public List<ShowSeat> finadAll() throws Exception {
		List<ShowSeat> li=showSeatRepository.findAll();
		/*
		 * if(li.size()==0) { throw new Exception("No Seats Found"); }
		 */
		return li;
		
	}

	@Override
	public Optional<ShowSeat> findById(long id) {
		// TODO Auto-generated method stub
		return showSeatRepository.findById(id);
	}

	@Override
	public ShowSeat UpdateById(ShowSeat showSeat) {
		// TODO Auto-generated method stub
		return showSeatRepository.save(showSeat);
	}

	@Override
	public String deleteById(long id) {
		// TODO Auto-generated method stub
		showSeatRepository.deleteById(id);
		return "Data Deleted Successfully";
	}

	@Override
	public String deleteAll(ShowSeat showSeat) {
		showSeatRepository.deleteAll();
		return "All Data Deleted Successfully";
	}

	

	/*
	 * @Override public ShowSeat cancelSeat(ShowSeat showSeat) {
	 * showSeat.setSeatStatus(SeatStatus.CANCELLED); return
	 * showSeatRepository.saveAndFlush(showSeat); }
	 * 
	 * @Override public ShowSeat bookSeat(ShowSeat showSeat) {
	 * showSeat.setSeatStatus(SeatStatus.BOOKED); return
	 * showSeatRepository.saveAndFlush(showSeat); }
	 * 
	 * @Override public ShowSeat blockedSeat(ShowSeat showSeat) {
	 * showSeat.setSeatStatus(SeatStatus.BLOCKED); return
	 * showSeatRepository.saveAndFlush(showSeat); }
	 */
	


}
