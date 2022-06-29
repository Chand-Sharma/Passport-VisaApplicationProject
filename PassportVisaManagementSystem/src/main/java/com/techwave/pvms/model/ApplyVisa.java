package com.techwave.pvms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ApplyVisa {

    @Id
    @Length(max = 13)
    private String userId;
    @Column(length=15)
    private String visaId;
    @Column(length = 25)
    private String country;
    @Column(length=25)
    private String destination;
    @Column(length=25)
    private String employeeOccupation; 
    @Column(length=25)
    private String dateOfApplication;
    @Column(length = 25)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MMM-dd")
    private String issueDate;
    @Column(length = 25)
    private String dateOfExpiry;
    @Column(length = 15)
    private int registrationCost;
}