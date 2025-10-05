package com.example.BookMyShow.BookMyShow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShow.BookMyShow.entity.User;
import com.example.BookMyShow.BookMyShow.repository.RoleRepository;
import com.example.BookMyShow.BookMyShow.repository.UserRepository;






@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
UserRepository userRepository;
	  
	  @Autowired
	  RoleRepository roleRepository;
	  

	  
	  @Autowired
	  BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	 @GetMapping("/get/all")
	  @PreAuthorize("hasRole('ADMIN')")
	  public ResponseEntity<List<User>> allAccess(@RequestBody User user) {
	    List<User> list=new ArrayList<>();
	    userRepository.findAll().forEach(list::add);
	    return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	   
	  }

	  @GetMapping("/get/{id}")
	  @PreAuthorize("hasRole('USER')")
	  public ResponseEntity<User> getById(@PathVariable long id)
	  {
		  Optional<User> list=userRepository.findById(id);
		  if(list.isPresent())
		  {
			  return new ResponseEntity<User>(list.get(),HttpStatus.FOUND);
		  }
		  else
		  {
			  return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		  }
	  }
		  




@GetMapping("/get/admin")
	  @PreAuthorize("hasRole('ADMIN')")
	  public String adminAccess() {
	    return "Admin Board.";
	  }

@PutMapping("/put/{id}")
@PreAuthorize("hasRole('USER')")
public ResponseEntity<User> updateById(@PathVariable long id,@RequestBody User user)
{
user.setId(id);
user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
User u=userRepository.save(user);
	return new ResponseEntity<User>(u,HttpStatus.OK);
}
	  
	  
  @DeleteMapping("/delete/{id}")
  @PreAuthorize("hasRole('USER')")
	  public String deleteById(@PathVariable long id)
	  {
		  userRepository.deleteById(id);
		  return "Delete All Records Successfully";
	  }

	  @DeleteMapping("/delete")
	  @PreAuthorize("hasRole('USER')")
	  public String deleteRecord(@RequestBody User user)
	  {
		  userRepository.deleteAll();
		  return "Delete All Records Successfully";
	  }

}
