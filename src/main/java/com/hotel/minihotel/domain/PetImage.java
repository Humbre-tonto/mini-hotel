package com.informatique.gov.helpdesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "PET_IMAGE")
@Data
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class PetImage extends DomainEntity<Integer> {
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Id
	@SequenceGenerator(name = "PetImageSequence", sequenceName = "PET_IMAGE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PetImageSequence")
	@Column(name = "id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PET_ID")
	private Pet pet;

	@Column(name = "IMAGE", nullable = false)
	private String image;

	@Column(name = "PROFILE_IMAGE")
	private Boolean profileImage;
}
