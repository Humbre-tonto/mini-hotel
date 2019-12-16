package com.hotel.minihotel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "TYPES")
@Data
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "code" }, callSuper = false)


public class Type extends DomainEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "CODE")
	private String code;
}
