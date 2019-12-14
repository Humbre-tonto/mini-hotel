package com.informatique.gov.helpdesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "APP_PET")
@Data
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "id" }, callSuper = false)

// @NamedEntityGraphs({
// @NamedEntityGraph(name = "Pet.fat", attributeNodes = {
// @NamedAttributeNode(value = "role"),
// @NamedAttributeNode(value = "credentials")}),
// @NamedEntityGraph(name = "Pet.thin", attributeNodes = {}) })
public class Pet extends DomainEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Id
	@SequenceGenerator(name = "PetSequence", sequenceName = "APP_PET_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PetSequence")
	@Column(name = "id")
	private Integer id;

	@Column(name = "NAME")
	private String englishName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GENDER_ID")
	private Gender gender;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PREFERENCES_ID")
	private PetPreferences petPreferences;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OWNER_ID")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PET_TYPE_BREED_ID")
	private PetTypeBreed petTypeBreed;

}
