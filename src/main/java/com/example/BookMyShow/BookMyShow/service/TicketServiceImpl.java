package com.example.BookMyShow.BookMyShow.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookMyShow.BookMyShow.config.QRCodeGenerator;
import com.example.BookMyShow.BookMyShow.entity.Booking;
import com.example.BookMyShow.BookMyShow.entity.CinemaHall;
import com.example.BookMyShow.BookMyShow.entity.SeatStatus;
import com.example.BookMyShow.BookMyShow.entity.Show;
import com.example.BookMyShow.BookMyShow.entity.ShowSeat;
import com.example.BookMyShow.BookMyShow.entity.Ticket;
import com.example.BookMyShow.BookMyShow.repository.BookingRepository;
import com.example.BookMyShow.BookMyShow.repository.ShowRepository;
import com.example.BookMyShow.BookMyShow.repository.ShowSeatRepository;
import com.example.BookMyShow.BookMyShow.repository.TicketRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository bookingRepository;
	
	@Autowired
	private BookingRepository bookingRepository2;
	
	@Autowired
	private BookingServiceImpl bookingServiceImpl;

	@Autowired
	private ShowSeatRepository showSeatRepository;
	
@Autowired
private QRCodeGenerator codeGenerator;

@Autowired
private MailService mailService;

	


	@Override
	public Ticket createMovie(Ticket ticket) throws WriterException, IOException, MessagingException {
		// TODO Auto-generated method stub
		
		long id=ticket.getBooking().getId();
		
		Booking booking=bookingRepository2.findById(id).get();
		
		booking.setTransaction_status("Paid");
		
		long id1=ticket.getBooking().getId();
		
		Booking booking2=bookingRepository2.findById(id1).get();
		
		booking2.setSeatstatus("CONFIRMED");
		
		long id2=ticket.getBooking().getId();
		
List<ShowSeat> showSeat=showSeatRepository.findAllById(id2);

for(ShowSeat seat:showSeat)
{
	seat.setSeatStatus("BOOKED");
}
//
//showSeat.setSeatStatus("BOOKED");

Set<ShowSeat>list=booking.getShowSeat();

String collect = list.stream().map(ShowSeat::getSeat_no).collect(Collectors.joining(", "));

for(int i=0;i<collect.length();i++)
{
	char charAt = collect.charAt(i);
	
	int no=(int) charAt;
	
	ticket.setNumberofseats(no);
	
}

String letter="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

String numbers="0123456789";


String result=letter + numbers;

StringBuilder builder=new StringBuilder();

Random random=new Random();

int length=5;

for(int i=0;i<length;i++)
{
	int num=random.nextInt(result.length());
	
	builder.append(result.charAt(num));
	
	
	 String string = builder.toString();
	 
	 
	 ticket.setBookingnumber(string);
}


Booking booking1=bookingServiceImpl.calculateTotalCost(id);

booking1.setTotal_cost(booking.getTotal_cost());

ticket.setTotal_cost(booking.getTotal_cost());


 bookingRepository2.save(booking);
 bookingRepository2.save(booking1);


		
QRCodeWriter qrCodeWriter = new QRCodeWriter();
BitMatrix bitMatrix = qrCodeWriter.encode(
        "BookingNumber: " + ticket.getBookingnumber() + "\n" +
        "CreatedOn: " + ticket.getCreatedon()+ "\n" +
        "User Name: "+booking.getUser().getFirst_name()+ "\n" +
        "Movie Name: "+booking.getShow().getCinemaHall().getMovie().getTitle()+ "\n" +
        "Theater: "+booking.getShow().getCinemaHall().getTheater().getName() +" , "+booking.getShow().getCinemaHall().getTheater().getLocation()+ "\n" +
        "Date & Time: "+booking.getShow().getCreatedon()+ "\n" +
        "Seat No: " + collect + "\n" +
        "Screen: " +booking.getShow().getCinemaHall().getName()+ "\n" +
        "Total Amaount: "+ticket.getTotal_cost()+ "\n" +
        "Quantity: "+ticket.getNumberofseats() +"tickets" +"\n" +
        "Transaction Status: "+booking.getTransaction_status(),
        BarcodeFormat.QR_CODE, 400, 400);

ByteArrayOutputStream baos = new ByteArrayOutputStream();
MatrixToImageWriter.writeToStream(bitMatrix, "PNG", baos);
byte[] qrBytes = baos.toByteArray();

// 5. Send email with QR attachment
mailService.sendMail(
        booking.getUser().getEmail(),
        "Ticket Confirmed",
        "Your ticket has been booked successfully. Please find QR code attached.",
        qrBytes,
        ticket.getId() + "-QRCODE.png"
);




		return bookingRepository.save(ticket);
	}

	@Override
	public List<Ticket> finadAll() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	@Override
	public List<Ticket> findById(Booking booking) {


		return bookingRepository.getByBooking(booking);
	}

	@Override
	public Ticket UpdateById(Ticket ticket) {
		// TODO Auto-generated method stub
		return bookingRepository.save(ticket);
	}

	@Override
	public String deleteById(long id) {
		bookingRepository.deleteById(id);
		return "Data Deleted Successfully";
	}

	@Override
	public String deleteAll(Ticket ticket) {
		bookingRepository.deleteAll();
		return "All Data Deleted Successfully";
	}
	
	/*
	 * @Override public Ticket calculateTotalCost(long id) { // TODO Auto-generated
	 * method stub List<Ticket> ticket=bookingRepository.findAll(); Set<ShowSeat>
	 * showSeat=new HashSet<ShowSeat>();
	 * 
	 * for(Ticket tickets:ticket) { if(id==tickets.getBooking().getId()) {
	 * showSeat.addAll(tickets.getShowSeat()); } }
	 * 
	 * double amount = 0; for (ShowSeat seat : showSeat) { amount = amount +
	 * seat.getPrice(); } Ticket booking=bookingRepository.getOne(id);
	 * booking.setTotal_cost(amount);
	 * 
	 * return booking ; }
	 */

}
