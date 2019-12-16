package com.hotel.minihotel.domain;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class DomainEntity<ID extends Serializable> implements DomainModel<ID>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	public DomainEntity(DomainEntity<ID> c){
		this.setId(c.getId());
	}
}
