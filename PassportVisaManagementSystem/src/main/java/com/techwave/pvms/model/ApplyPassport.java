package com.techwave.pvms.model;

import java.time.LocalDate;

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
public class ApplyPassport {
	@Id
	@Length(max = 13)
	private String userId;
	@Column(length = 25)
	private String reason;
	@Column(length = 25)
	private String country;
	@Column(length = 25)
	private String state;
	@Column(length = 25)
	private String city;
	@Column(length = 15)
	private Long pin;
	@Column(length = 25)
	private String serviceType;
	@Column(length = 15)
	private int amount;
	@Column(length = 15)
	private String bookletType;
	@Column(length = 25)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MMM-dd")
	private LocalDate issueDate;
	@Column(length = 15)
	private String passId;
	@Column(length = 15)
	private String passType;
	
}
	
//	package com.techwave.pvms.model;
//
//	import java.time.LocalDate;
//
//	import javax.persistence.Entity;
//
//	import com.fasterxml.jackson.annotation.JsonFormat;
//
//	import lombok.AllArgsConstructor;
//	import lombok.Getter;
//	import lombok.NoArgsConstructor;
//	import lombok.Setter;
//	import lombok.ToString;
//
//	@Setter
//	@Getter
//	@NoArgsConstructor
//	@AllArgsConstructor
//	@ToString
//	@Entity
//	public class PassRenewal {
//		private String reason;
//		private String userId;
//		private String country;
//		private String state;
//		private String city;
//		private String serviceType;
//		private String bookletType;
//		private String issueDate;
//
//	}





