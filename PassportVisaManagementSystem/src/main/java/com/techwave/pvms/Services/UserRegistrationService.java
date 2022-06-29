package com.techwave.pvms.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techwave.pvms.model.UserCityAddress;
import com.techwave.pvms.model.UserRegistration;
import com.techwave.pvms.model.UserStateAddress;
import com.techwave.pvms.repository.IUserCity;
import com.techwave.pvms.repository.IUserRegistration;
import com.techwave.pvms.repository.IUserState;



@Service
public class UserRegistrationService {

	@Autowired
	IUserRegistration iUserRegistration;
	
	@Autowired
	IUserState iUserState;
	
	@Autowired
	IUserCity iUserCity;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
//	@Autowired
//	UserStateAddress usa;
	// User Registration Module
	int max = 999;
	int min = 100;
	int m = 2;
	int n = 0;
	String s[] = { "@", "#", "$" };

	public String InsertUser(UserRegistration user) {
		System.out.println(user.toString());
		Integer i = iUserRegistration.getSqe();
		// generate user id
		user.setUsername(user.getApplyType() + "-" + i);

		// generate password
		LocalDateTime now = LocalDateTime.now();
		int dd = now.getDayOfMonth();
		Month mm = now.getMonth();
		int num = (int) (Math.random() * (max - min + 1) + min);
		int special = (int) (Math.random() * (m - n + 1) + n);
		String pass = dd + mm.toString().substring(0, 3) + s[special] + num;
		user.setPassword(pass);
		System.out.println(pass);
		
//		UserStateAddress usa =new UserStateAddress();
//	
//		usa.setStateId(usa.getStateId());
//		usa.setStateName(usa.getStateName());
//		user.setStateId(usa);
//		
//		
//		UserCityAddress uca=new UserCityAddress();
//		
//		
//		
//		uca.setCity_Id(uca.getCity_Id());
//		uca.setCityName(uca.getCityName());
//		uca.setStateId(uca.getStateId());
//		user.setCity(uca);
		
		
		
		DateTimeFormatter D = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		LocalDate dob = LocalDate.parse(user.getDob(), D);
		LocalDate curDate = LocalDate.now();
		// calculates the difference betwween two dates
		Period period = Period.between(dob, curDate);
		System.out.printf("Your age is %d years %d months and %d days.", period.getYears(), period.getMonths(),
				period.getDays());
		String s[] = { "Infant", "Children", "Teen", "Adult", "Senior Citizen" };
		if (period.getYears() >= 0 && period.getYears() <= 1) {

			user.setCitizenType(s[0]);
		} else if (period.getYears() >= 1 && period.getYears() <= 10) {
			user.setCitizenType(s[1]);
		} else if (period.getYears() >= 10 && period.getYears() <= 20) {
			user.setCitizenType(s[2]);
		} else if (period.getYears() >= 20 && period.getYears() <= 50) {
			user.setCitizenType(s[3]);
		} else {
			user.setCitizenType(s[4]);
		}
		System.out.println(user.getPassword());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Optional<UserRegistration> U = iUserRegistration.findById(user.getFirstName());
		if (U.isPresent()) {
			return "User already exists";
		} else {
			iUserRegistration.save(user);
		}

		//iUserRegistration.save(u);
		String str = "Dear User\n" + "Your User Id is" + " " + user.getUsername() + " " + "and your password is" + " "
				+ pass + "\n" + "You are planning for" + " " + user.getApplyType() + " " + "and your citizen type is" + " "
				+ user.getCitizenType();
		System.out.println(str);
		return str;
	}

	public List<UserRegistration> getUsers() {

		return iUserRegistration.findAll();
	}
	
	

	public List<UserStateAddress> getAllState() {
		// TODO Auto-generated method stub
		return iUserState.findAll();
	}
	
	public List<UserCityAddress> getAllCity() {
		// TODO Auto-generated method stub
		return iUserCity.findAll();
	}
	
	

}
