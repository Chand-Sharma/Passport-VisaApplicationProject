package com.techwave.pvms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.pvms.Services.UserRegistrationService;
import com.techwave.pvms.model.UserRegistration;

@RestController
public class UserController {
	
	
	@Autowired
	UserRegistrationService userRegistrationService;
	
	@PostMapping("/insertuser")
	public String InsertUser(@RequestBody UserRegistration u) {
		System.out.println(u.toString());
		return userRegistrationService.InsertUser(u);
	}
	

	@GetMapping("/users")
	public ResponseEntity<?> getUsers(){
		return new ResponseEntity<>(userRegistrationService.getUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/states")
	public ResponseEntity<?> getAllStates(){
		return new ResponseEntity<>(userRegistrationService.getAllState(),HttpStatus.OK);
	}
	
	@GetMapping("/cities")
	public ResponseEntity<?> getAllCities(){
		return new ResponseEntity<>(userRegistrationService.getAllCity(),HttpStatus.OK);
	}
	
	
}
