package com.example.BookMyShow.BookMyShow.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.BookMyShow.BookMyShow.entity.Booking;
import com.example.BookMyShow.BookMyShow.entity.SeatStatus;
import com.example.BookMyShow.BookMyShow.entity.Show;
import com.example.BookMyShow.BookMyShow.entity.ShowSeat;
import com.example.BookMyShow.BookMyShow.projection.ShowSeatProjection;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>{

public ShowSeat findByShowId(long show1);

@Modifying
@Transactional
@Query(value="UPDATE showseats sh\r\n"
		+ "LEFT JOIN booking_show_seat bs ON sh.id = bs.show_seat_id\r\n"
		+ "LEFT JOIN booking b ON b.id = bs.booking_id\r\n"
		+ "LEFT JOIN tickets t ON t.booking_id = b.id\r\n"
		+ "SET sh.seat_status = 'BOOKED'\r\n"
		+ "WHERE t.booking_id = :id",nativeQuery = true)
void findByShowSeats(long id);

public List<ShowSeat> findAllById(long id2);

@Query(value="select * from showseats where seat_status='Available'",nativeQuery = true)
List<ShowSeat> findbySeatstatus();


List<ShowSeat> findByShow(Show show);






}
