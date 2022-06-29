package com.techwave.pvms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techwave.pvms.model.UserCityAddress;


public interface IUserCity extends JpaRepository<UserCityAddress,String> {
	
	List<UserCityAddress> findAll();

}
