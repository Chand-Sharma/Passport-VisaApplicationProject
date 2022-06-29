package com.techwave.pvms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.pvms.Services.ApplyService;
import com.techwave.pvms.model.ApplyPassport;

@RestController
public class ApplyController {
	
	@Autowired
	ApplyService applyService;
	
	@PostMapping("/applyPass")
	public String applyPass(@RequestBody ApplyPassport pass  ) {
		String S=applyService.applyPass(pass);
	
		return S;
	}
	
	@PostMapping("/renewalPass")
	public String renewalPass(@RequestBody ApplyPassport pass  ) {
		String S=applyService.renewalPass(pass);
	
		return S;
	}
	
	
	
	
	
}
