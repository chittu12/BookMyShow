package com.example.BookMyShow.BookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookMyShow.BookMyShow.entity.User;




@Repository
public interface UserRepository extends JpaRepository<User,Long> {

Optional<User> findByEmail(String email);

Boolean existsByUsername(String username);

Boolean existsByEmail(String email);
}
