package com.informatique.gov.helpdesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "PET_PREFRENCES")
@Data
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class PetPreferences extends DomainEntity<Integer> {
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Id
	@Column(name = "id")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PET_ID")
	private Pet pet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PREFRENCES_ID")
	private Preferences preference;
}
