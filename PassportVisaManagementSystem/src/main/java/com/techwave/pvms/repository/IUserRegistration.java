package com.techwave.pvms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techwave.pvms.model.UserRegistration;

@Repository
public interface IUserRegistration extends JpaRepository<UserRegistration, String> {

	@Query(value="select user_id_seq.nextval from dual", nativeQuery = true)
	public Integer getSqe();

	public UserRegistration findByUsername(String username);
}


