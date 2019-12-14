package com.informatique.gov.helpdesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "APP_USER_CREDENTIALS")
@Data
@ToString(of = { "id", "password" })
@EqualsAndHashCode(of = { "id", "password" }, callSuper = false)
public class UserCredentials extends DomainEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "PASSWORD")
	private String password;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID")
	@MapsId
	private User user;

}
