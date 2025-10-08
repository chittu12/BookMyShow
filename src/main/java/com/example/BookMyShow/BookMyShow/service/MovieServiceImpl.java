package com.example.BookMyShow.BookMyShow.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.BookMyShow.BookMyShow.entity.Movie;
import com.example.BookMyShow.BookMyShow.repository.MovieRepository;



@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie createMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> finadAll() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

	@Override
	public Optional<Movie> findById(long id) {
		// TODO Auto-generated method stub
		return movieRepository.findById(id);
	}

	@Override
	public Movie UpdateById(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.save(movie);
	}

	@Override
	public String deleteById(long id) {
		// TODO Auto-generated method stub
		movieRepository.deleteById(id);
		return "Data Deleted Successfully";
	}

	@Override
	public String deleteAll(Movie movie) {
		// TODO Auto-generated method stub
		movieRepository.deleteAll();
		return "All Data Deleted Successfully";
	}

	
	public List<Movie> sortByMovie(String field)
	{
		return movieRepository.findAll(Sort.by(Sort.Direction.DESC,field));
	}
	
	
	public void createExcel(HttpServletResponse response) throws IOException
	{
		List<Movie> movie=movieRepository.findAll();
		HSSFWorkbook hssfWorkbook=new HSSFWorkbook();
		
		HSSFSheet hssfSheet=hssfWorkbook.createSheet();
		
		HSSFRow hssfRow=hssfSheet.createRow(0);
		
		hssfRow.createCell(0).setCellValue("id");
		hssfRow.createCell(1).setCellValue("title");
		
		hssfRow.createCell(2).setCellValue("description");
		hssfRow.createCell(3).setCellValue("durationmins");
		hssfRow.createCell(4).setCellValue("language");
		hssfRow.createCell(5).setCellValue("releasedate");
		hssfRow.createCell(6).setCellValue("country");
		hssfRow.createCell(7).setCellValue("genre");
		
		int dataInedex=1;
		
		for(Movie movie2:movie)
		{
		HSSFRow hssfRow2=hssfSheet.createRow(dataInedex);
		hssfRow2.createCell(0).setCellValue(movie2.getId());
		hssfRow2.createCell(1).setCellValue(movie2.getTitle());
		hssfRow2.createCell(2).setCellValue(movie2.getDescription());
		hssfRow2.createCell(3).setCellValue(movie2.getDurationmins());
		hssfRow2.createCell(4).setCellValue(movie2.getLanguage());
		hssfRow2.createCell(5).setCellValue(movie2.getReleasedate());
		hssfRow2.createCell(6).setCellValue(movie2.getCountry());
		hssfRow2.createCell(7).setCellValue(movie2.getGenre());
		
		
		dataInedex++;
		
		
		
		
		}
		
		ServletOutputStream ops=response.getOutputStream();
		hssfWorkbook.write(ops);
		hssfWorkbook.close();
		ops.close();
		
		
	}
	
}
