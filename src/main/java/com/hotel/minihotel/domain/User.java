package com.hotel.minihotel.domain;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "USERS")
@Data
@ToString(of = { "id", "name" })
@EqualsAndHashCode(of = { "name" }, callSuper = false)

@NamedEntityGraphs({
		@NamedEntityGraph(name = "User.fat", attributeNodes = { @NamedAttributeNode(value = "role")}),
		@NamedEntityGraph(name = "User.thin", attributeNodes = {}) })
public class User extends DomainEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	@Id
	@SequenceGenerator(name = "UserSequence", sequenceName = "USERS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSequence")
	@Column(name = "id")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name="PASSWORD")
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	private Role role;

}
