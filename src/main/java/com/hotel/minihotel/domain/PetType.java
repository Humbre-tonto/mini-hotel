package com.informatique.gov.helpdesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "PET_TYPE")
@Data
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "id" }, callSuper = false)

public class PetType extends DomainEntity<Integer>{
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "ENGLISH_NAME")
	private String englishName;
	
	@Column(name = "CODE")
	private String code;
}
