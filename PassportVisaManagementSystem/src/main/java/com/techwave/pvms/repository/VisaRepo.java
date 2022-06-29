package com.techwave.pvms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techwave.pvms.model.ApplyVisa;

public interface VisaRepo extends JpaRepository<ApplyVisa, String> {

    @Query(value="select visa_id_seq.nextval from dual", nativeQuery = true)
    public Integer getSeqforapplyVisa();
}