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
@Table(name = "PREFRENCES")
@Data
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "id" }, callSuper = false)

public class Preferences extends DomainEntity<Integer> {
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
}
