package com.example.BookMyShow.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookMyShow.BookMyShow.entity.ERole;
import com.example.BookMyShow.BookMyShow.entity.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

	Optional<Role>  findByName(ERole name);
}
