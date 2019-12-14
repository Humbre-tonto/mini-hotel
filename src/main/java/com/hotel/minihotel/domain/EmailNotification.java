package com.informatique.gov.helpdesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "EMAIL_NOTIFICATION")
@Data
@ToString(of = { "id"})
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class EmailNotification extends CreationAuditableDomainEntity<Long, String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	@Id
	@SequenceGenerator(name = "EmailNotificationSequence", sequenceName = "EMAIL_NOTIFICATION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmailNotificationSequence")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "IS_SENT")
	private Boolean isSent;
	
	@Lob 
	@Column(name = "BODY")
	private String body;
	
	@Column(name = "SUBJECT")
	private String subject;
	
	@Column(name = "RECIPIENT_EMAIL")
	private String recipientEmail;
}
