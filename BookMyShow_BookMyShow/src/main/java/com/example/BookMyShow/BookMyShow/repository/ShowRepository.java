package com.example.BookMyShow.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyShow.BookMyShow.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

}
