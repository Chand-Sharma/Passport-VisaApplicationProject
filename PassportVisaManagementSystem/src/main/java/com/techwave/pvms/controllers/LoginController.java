package com.techwave.pvms.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.pvms.Services.UserLoginService;
import com.techwave.pvms.model.UserLogin;

@RestController
public class LoginController {
	@Autowired
	UserLoginService uLoginService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody UserLogin userLogin) {
		return new ResponseEntity<>(uLoginService.login(userLogin),HttpStatus.OK);
	}

}
