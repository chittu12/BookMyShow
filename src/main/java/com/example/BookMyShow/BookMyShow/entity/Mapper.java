package com.example.BookMyShow.BookMyShow.entity;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Mapper {
	 @Bean
	    public ModelMapper getModelMapper() {
	        return new ModelMapper();
	    }
}
