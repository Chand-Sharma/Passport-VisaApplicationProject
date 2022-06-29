package com.techwave.pvms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techwave.pvms.model.UserStateAddress;

public interface IUserState extends JpaRepository<UserStateAddress, String> {

	List<UserStateAddress> findAll();

	

}
