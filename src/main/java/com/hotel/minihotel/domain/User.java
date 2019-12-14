package com.informatique.gov.helpdesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "APP_USER")
@Data
@ToString(of = { "id", "loginName" })
@EqualsAndHashCode(of = { "loginName" }, callSuper = false)

@NamedEntityGraphs({
		@NamedEntityGraph(name = "User.fat", attributeNodes = { @NamedAttributeNode(value = "role"),
				@NamedAttributeNode(value = "credentials")}),
		@NamedEntityGraph(name = "User.thin", attributeNodes = {}) })
public class User extends DomainEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Id
	@SequenceGenerator(name = "UserSequence", sequenceName = "APP_USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSequence")
	@Column(name = "id")
	private Integer id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String LastName;

	@Column(name = "MOBILE")
	private String mobile;
	
	@Column(name = "EMAIL")
	private String email;
	
	@NaturalId
	@Column(name = "LOGIN_NAME")
	private String loginName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	@OneToOne(mappedBy = "user")
	@PrimaryKeyJoinColumn
	private UserCredentials credentials;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	private Pet pet;
//	

	
}
