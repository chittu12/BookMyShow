package com.example.BookMyShow.BookMyShow.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShow.BookMyShow.entity.ERole;
import com.example.BookMyShow.BookMyShow.entity.Role;
import com.example.BookMyShow.BookMyShow.entity.User;
import com.example.BookMyShow.BookMyShow.jwt.JwtUtils;
import com.example.BookMyShow.BookMyShow.payload.request.LoginRequest;
import com.example.BookMyShow.BookMyShow.payload.request.SignUpRequest;
import com.example.BookMyShow.BookMyShow.payload.response.JwtResponse;
import com.example.BookMyShow.BookMyShow.payload.response.MessageResponse;
import com.example.BookMyShow.BookMyShow.repository.RoleRepository;
import com.example.BookMyShow.BookMyShow.repository.UserRepository;
import com.example.BookMyShow.BookMyShow.service.UserDetailsImpl;



@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	  @Autowired
	  RoleRepository roleRepository;
	  
	  @Autowired
	  JwtUtils jwtUtils;
	  
	  @Autowired
	  AuthenticationManager authenticationManager;

		/* @PreAuthorize("hasRole('ADMIN')") */
	@PostMapping("/post/user/signup")

	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest)
	{
		if(userRepository.existsByUsername(signUpRequest.getUsername()))
		{
			return ResponseEntity
					.badRequest()
					.body("Error: Username Already Exist!");
		}
		
		if(userRepository.existsByEmail(signUpRequest.getEmail()))
		{
			return ResponseEntity
					.badRequest()
					.body("Error: Email Alredy Exist!");
		}
		
		User user=new User(signUpRequest.getFirst_name(),signUpRequest.getLast_name(),signUpRequest.getUsername(),signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()),signUpRequest.getPhone(),signUpRequest.getGender());
				
				
			    Set<String> strRoles = signUpRequest.getRole();
			    Set<Role> roles = new HashSet<>();
			    
			    if (strRoles == null) {
				      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
				          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				      roles.add(userRole);
				    } else {
				      strRoles.forEach(role -> {
				        switch (role) {
				        case "admin":
				          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
				              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				          roles.add(adminRole);

				       

				          break;
				        default:
				          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
				              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				          roles.add(userRole);
				        }
				      });
				    }

				    user.setRoles(roles);
				    userRepository.save(user);

				    return ResponseEntity.ok(new MessageResponse("user registered successfully!"));
				  }
	
	
	@PostMapping("/post/user/signin")
	
	  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtUtils.generateJwtToken(authentication);
	    
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok(new JwtResponse(jwt, 
	                         userDetails.getId(), 
	                         userDetails.getUsername(), 
	                         userDetails.getEmail(), 
	                         roles));
	  }
	}
	
	
	

