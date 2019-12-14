package com.informatique.gov.helpdesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "SMS_NOTIFICATION")
@Data
@ToString(of = { "id"})
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class SmsNotification extends CreationAuditableDomainEntity<Long, String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	@Id
	@SequenceGenerator(name = "SmsNotificationSequence", sequenceName = "SMS_NOTIFICATION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SmsNotificationSequence")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "TEXT")
	private String text;
	
	@Column(name = "SENDER")
	private String sender;
	
	@Column(name = "IS_SENT")
	private Boolean isSent;
	
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
}
