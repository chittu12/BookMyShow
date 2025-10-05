package com.example.BookMyShow.BookMyShow.config;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.springframework.stereotype.Service;

import com.example.BookMyShow.BookMyShow.entity.Ticket;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QRCodeGenerator {
	
	
	public static byte[] QrcodeBitmatrix(BitMatrix bitMatrix) throws IOException
	{
		ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
		
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", arrayOutputStream);
		return arrayOutputStream.toByteArray();
		
	}
	
	
	
	

	public static void QRCodeGenerator(Ticket ticket) throws WriterException, IOException
	{
		String qrCodePath="C:\\Users\\Chittu\\QRCode";
		String qrCodeName=qrCodePath+ticket.getId()+"-QRCODE.png";
		QRCodeWriter qrCodeWriter=new QRCodeWriter();
		BitMatrix bitMatrix=qrCodeWriter.encode("TicketId:"+ticket.getId()+"\n"
			+"NumberOfSeats:"+ticket.getNumberofseats()+"\n"
			+"BookingNumber:"+ticket.getBookingnumber()+"\n"
			+"CreatedOn:"+ticket.getCreatedon()
		
				,
			BarcodeFormat.QR_CODE,400,400
				);
		
		byte[] qrBytes =QrcodeBitmatrix(bitMatrix);
		
		Path path=FileSystems.getDefault().getPath(qrCodeName);
		MatrixToImageWriter.writeToPath(bitMatrix,"PNG", path);
	}
}
