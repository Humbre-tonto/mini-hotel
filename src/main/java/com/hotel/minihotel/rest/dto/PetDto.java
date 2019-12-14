package com.informatique.gov.helpdesk.rest.dto;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.PetTypeBreed;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class PetDto implements UserModel<Integer> {
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	private Integer id;
	private String englishName;
	private GenderDto gender;
	private PetPreferencesDto petPreferences;
	private UserDto user;
	private PetTypeBreedDto petTypeBreed;


}
