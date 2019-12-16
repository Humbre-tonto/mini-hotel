package com.hotel.minihotel.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public abstract class AuditableDomainEntity<ID extends Serializable, T extends Serializable> extends DomainEntity<ID> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	@CreatedBy
	@Column(name = "CREATE_BY", updatable = false)
	private T createBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", updatable = false)
	private Date createDate;

	@CreatedBy
	@Column(name = "UPDATE_BY")
	private T updateBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	public AuditableDomainEntity(AuditableDomainEntity<ID, T> a) {
		this.setCreateBy(a.getCreateBy());
		this.setCreateDate(a.getCreateDate());
		this.setUpdateBy(a.updateBy);
		this.setUpdateDate(a.updateDate);
	}
}
