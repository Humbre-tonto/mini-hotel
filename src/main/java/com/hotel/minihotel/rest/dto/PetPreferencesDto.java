package com.informatique.gov.helpdesk.rest.dto;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class PetPreferencesDto implements UserModel<Integer> {
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	private Integer id;

	private PetDto pet;
	private PreferencesDto preferences;
}
