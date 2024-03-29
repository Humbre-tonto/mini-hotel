package com.hotel.minihotel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "APP_ROLE")
@Data
@ToString(of = {"id", "code", "englishName"})
@EqualsAndHashCode(of = {"code"}, callSuper = false)
public class Role extends DomainEntity<Byte> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	@Id
    @Column(name = "id")
    private Byte id;
	
	@NaturalId
	@Column(name = "code")
	private String code;
	
	@Column(name = "ENGLISH_NAME")
	private String englishName;
	
}
