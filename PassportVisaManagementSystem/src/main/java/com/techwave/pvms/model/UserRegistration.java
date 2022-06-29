package com.techwave.pvms.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

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
public class UserRegistration {
	
	@Id
//	@GenericGenerator(name = "user_key",strategy = "com.techwave.pvms.utility.UserKeyGenerator")
//	@GeneratedValue(generator = "user_key")	
	@Length(max = 15)
	private String username;
	@Column(length = 10)
	private String firstName;
	@Column(length = 15)
	private String surName;
	@Column(length = 13)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MMM-dd")
	private String dob;
	
//	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinTable(name = "USER_ADDRESS",joinColumns = {@JoinColumn(name="username",referencedColumnName = "username")},
//	inverseJoinColumns = {@JoinColumn(name="address_id",referencedColumnName = "addressId")})
//	private List<Address> addresses=new ArrayList<Address>();
	
//	@JsonFormat(shape=JsonFormat.Shape.STRING)
//	@OneToOne(cascade = {CascadeType.ALL})
//	@JoinColumn(name="stateId")
//	UserStateAddress stateId;
//	@JsonFormat(shape=JsonFormat.Shape.STRING)
//	@OneToOne(cascade = {CascadeType.ALL})
//	@JoinColumn(name="cityId")
//	UserCityAddress city;
	
	@Column(length = 15)
	private String stateName;
	
	@Column(length = 15)
	private String cityName;
	
	@Column(length = 15)
	private Long contactNo;
	@Column(length = 25)
	private String emailAddress;
	@Column(length = 10)
	private String qualification;
	@Column(length = 10)
	private String gender;
	@Column(length = 15)
	private String applyType;
	@Column(length = 25)
	private String hintQuestion;
	@Column(length = 25)
	private String hintAnswer;
	@Column(length = 200)
	private String password;
	@Column(length = 15)
	private String citizenType;
	
}

