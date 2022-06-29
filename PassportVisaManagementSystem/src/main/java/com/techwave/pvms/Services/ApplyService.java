package com.techwave.pvms.Services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.techwave.pvms.model.ApplyPassport;
import com.techwave.pvms.model.UserRegistration;
import com.techwave.pvms.repository.ApplyRepo;

@Service
public class ApplyService {

	@Autowired
	ApplyRepo applyRepo;

//	@Autowired(required = true)
//	UserRegistration ur;

	public String applyPass(ApplyPassport pass) {
		Integer i = applyRepo.getSeqforapply();
		// generate user id
		pass.setPassId(pass.getBookletType() + i);

		//pass.setUserId(ur.getUsername());
		String str[] = { "Normal", "Tatkal" };
		int amt[] = { 2500, 3500 };
		if (pass.getServiceType().equals(str[0])) {
			pass.setAmount(amt[0]);
		} else {
			pass.setAmount(amt[1]);
		}
		LocalDate now = LocalDate.now();
		pass.setIssueDate(now);
		// System.out.println(pass);
		//UserRegistration ur=new UserRegistration();
		Optional<ApplyPassport> U = applyRepo.findById(pass.getUserId());
		if (U.isPresent()) {
			 return "User already exists"; 
		}
		else {
			applyRepo.save(pass);
		}
		//applyRepo.save(pass);
		String str1 = "Need the passport number while giving payment? Please note down your Id\n"
				+ "Your Passport Id is" + " " + pass.getPassId() + " " + "Passport application cost is Rs."
				+ pass.getAmount();
	 System.out.println(str1);
		return str1;
	}

	public String renewalPass(ApplyPassport pass) {
		
		Integer i = applyRepo.getSeqforrenewal();
		// generate user id
		pass.setPassId(pass.getBookletType() + i);
		
		//generate
		String str[] = { "Normal", "Tatkal" };
		int amt[] = { 2500, 3500 };
		if (pass.getServiceType().equals(str[0])) {
			pass.setAmount(amt[0]);
		} else {
			pass.setAmount(amt[1]);
		}
		LocalDate now = LocalDate.now();
		pass.setIssueDate(now);
		
		//
		Optional<ApplyPassport> U = applyRepo.findById(pass.getUserId());
		if (U.isPresent()) {
			 return "User already exists"; 
		}
		else {
			applyRepo.save(pass);
		}
		
		System.out.println(pass);
		String str1 = "Passport re issue is successfully done.\n"
				+ "Your Temporary Passport Id is" + " " + pass.getPassId() + " " + "Passport application cost is Rs."
				+ pass.getAmount();
	 System.out.println(str1);
		return str1;
	}

}
