package com.hotel.minihotel.rest.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDetailsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private String username;
	private String role;
	private String firstName;
	private String lastName;
	private String mobileNumber1;
	private String mobileNumber2;
	private String emailAddress;
	private Long civilNumber;
}
