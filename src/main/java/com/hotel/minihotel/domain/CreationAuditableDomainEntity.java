package com.informatique.gov.helpdesk.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public abstract class CreationAuditableDomainEntity<ID extends Serializable, T extends Serializable> extends DomainEntity<ID>{
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	@CreatedBy
	@Column(name = "create_by", updatable = false)
	private T createBy;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", updatable = false)
	private Date createDate;
	
	public CreationAuditableDomainEntity(CreationAuditableDomainEntity<ID, T> c){
		super(c);
		this.setCreateBy(c.getCreateBy());
		this.setCreateDate(c.getCreateDate());
	}
}
