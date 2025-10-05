package com.example.BookMyShow.BookMyShow.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.BookMyShow.BookMyShow.entity.Mail;

@Service
public class MailService {

	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("$(spring.mail.username)")
	private String fromMail;
	
	
	public void sendMail(String mail,String subject, String text,byte[] qrBytes, String attachment) throws MessagingException
	
{
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
	
		helper.setFrom(fromMail);
		helper.setSubject("confirm ticket");
		helper.setText("Ticket Booked Suceessfully");
		helper.setTo(mail);

		helper.addAttachment(attachment,new ByteArrayResource(qrBytes));
		
		javaMailSender.send(mimeMessage);
	}
	
}
