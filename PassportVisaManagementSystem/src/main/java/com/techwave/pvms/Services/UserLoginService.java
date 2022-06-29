package com.techwave.pvms.Services;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techwave.pvms.model.UserLogin;
import com.techwave.pvms.model.UserRegistration;
import com.techwave.pvms.repository.IUserRegistration;

@Service
public class UserLoginService implements UserDetailsService{
	
	@Autowired
	IUserRegistration iUserRegistration;

	public String login(UserLogin userLogin) {
		
		
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserRegistration userRegistration=iUserRegistration.findByUsername(username);
		
		
		return new User(userRegistration.getUsername(),userRegistration.getPassword(),new ArrayList<GrantedAuthority>());
	}

}
