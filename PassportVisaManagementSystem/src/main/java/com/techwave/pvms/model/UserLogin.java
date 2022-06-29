package com.techwave.pvms.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLogin {

	@NotBlank(message = "User Id can not be blank")
	private String userId;
	@NotBlank(message = "Password can not be blank")
	private String password;
	private Double contactNo;
}
