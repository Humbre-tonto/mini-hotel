package com.informatique.gov.helpdesk.domain;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class DomainEntity<ID extends Serializable> implements DomainModel<ID>{

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	public DomainEntity(DomainEntity<ID> c){
		this.setId(c.getId());
	}
}
