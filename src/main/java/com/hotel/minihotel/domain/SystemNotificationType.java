package com.informatique.gov.helpdesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "REF_SYSTEM_NOTIFICATION_TYPE")
@Data
@ToString(of = {"id", "code", "englishName"})
@EqualsAndHashCode(of = { "code" }, callSuper = false)
@NoArgsConstructor
public class SystemNotificationType extends DomainEntity<Byte>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	
	public SystemNotificationType(String code){
		this.code = code;
	}
	
	@Id
    @Column(name = "id")
    private Byte id;
	
	@NaturalId
	@Column(name = "code")
	private String code;
	
	@Column(name = "ENGLISH_NAME")
	private String englishName;
	
	@Column(name = "ARABIC_NAME")
	private String arabicName;
}
