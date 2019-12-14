package com.informatique.gov.helpdesk.rest.dto;

import java.io.Serializable;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;

@Data
public class UserDetailsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private String username;
	private String role;
	private String firstName;
	private String lastName;
	private String mobileNumber1;
	private String mobileNumber2;
	private String emailAddress;
	private Long civilNumber;
	private AuthenticationTokenDto token;
}
