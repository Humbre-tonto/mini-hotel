package com.informatique.gov.helpdesk.rest.dto;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = {"id", "code", "arabicName", "englishName"})
@EqualsAndHashCode(of = {"code"}, callSuper = false)
public class CommunicationChannelDto implements UserModel<Byte> {
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

    private Byte id;

	private String code;

	private String englishName;
	
	private String arabicName;
}