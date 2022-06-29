package com.techwave.pvms.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techwave.pvms.Services.UserRegistrationService;
import com.techwave.pvms.model.ApplyPassport;
import com.techwave.pvms.model.UserStateAddress;

public interface ApplyRepo extends JpaRepository<ApplyPassport, String>{
	
	@Query(value="select pass_id_seq.nextval from dual", nativeQuery = true)
	public Integer getSeqforapply();
	
	@Query(value="select ren_pass_id_seq.nextval from dual", nativeQuery = true)
	public Integer getSeqforrenewal();
	
}
