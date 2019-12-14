package com.informatique.gov.helpdesk.rest.dto;

import com.informatique.gov.helpdesk.ShowDogVersion;

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
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	private Integer id;
	private String firstName;
	private String lastName;
	private RoleDto role;
	private String loginName;
	private String email;
	private String mobile; 
//	private PetDto	pet;
}
