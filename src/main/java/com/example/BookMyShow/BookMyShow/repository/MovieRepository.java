package com.example.BookMyShow.BookMyShow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.BookMyShow.BookMyShow.entity.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long> {



}
