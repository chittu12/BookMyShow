//package com.example.BookMyShow.BookMyShow.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.BookMyShow.BookMyShow.entity.Mail;
//import com.example.BookMyShow.BookMyShow.service.MailService;
//
//@RestController
//@RequestMapping("/mail")
//public class MailController {
//
//	@Autowired
//	private MailService mailService;
//	
//	@PostMapping("/post/{mail}")
//	@PreAuthorize("hasRole('admin')")
//	public String sendMails(@PathVariable String mail,@RequestBody Mail mails)
//	{
//		mailService.sendMail(mail, mails);
//		return "Ticket Booked Successfully";
//	}
//}
