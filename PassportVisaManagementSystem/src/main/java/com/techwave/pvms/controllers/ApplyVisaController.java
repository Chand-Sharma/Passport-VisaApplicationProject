package com.techwave.pvms.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.pvms.Services.ApplyServiceVisa;
import com.techwave.pvms.model.ApplyVisa;
@RestController
public class ApplyVisaController {

    @Autowired
    ApplyServiceVisa visaservice;

//    @GetMapping("/all")
//    public List<ApplyVisa> getall()
//    {
//        return visaservice.getall();
//    }



    @PostMapping("/applyVisa")
    public String applyVisa(@RequestBody ApplyVisa pass) {
        System.out.println("Hello");
        String S=visaservice.applyVisa(pass);
        System.out.println(pass);
        System.out.println(S);
        return S;
    }

}