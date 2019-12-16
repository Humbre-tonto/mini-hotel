package com.hotel.minihotel.rest.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = { "id", "loginName" })
@EqualsAndHashCode(of = { "loginName" }, callSuper = false)
public class UserDto implements UserModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	private Integer id;
	private String firstName;
	private String lastName;
	private RoleDto role;
	private String loginName;
	private String email;
	private String mobile; 
//	private PetDto	pet;
}
