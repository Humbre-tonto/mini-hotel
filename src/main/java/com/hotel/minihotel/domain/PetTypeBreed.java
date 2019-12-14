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
@Table(name = "PET_TYPE_BREED")
@Data
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "id" }, callSuper = false)

// @NamedEntityGraphs({
// @NamedEntityGraph(name = "Pet.fat", attributeNodes = {
// @NamedAttributeNode(value = "role"),
// @NamedAttributeNode(value = "credentials")}),
// @NamedEntityGraph(name = "Pet.thin", attributeNodes = {}) })

public class PetTypeBreed extends DomainEntity<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "ENGLISH_NAME")
	private String englishName;
	
	@Column(name = "CODE")
	private String code;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PET_TYPE_ID")
	private PetType petType;
}
