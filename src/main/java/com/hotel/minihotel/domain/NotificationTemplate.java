package com.informatique.gov.helpdesk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "NOTIFICATION_TEMPLATE")
@Data
@ToString(of = { "id", "eventCode" })
@EqualsAndHashCode(of = { "eventCode" }, callSuper = false)
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class NotificationTemplate extends DomainEntity<Short>{
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	@Id
	@Column(name = "ID")
	private Short id;
	
	@Column(name = "EVENT_CODE")
	private String eventCode;
	
	@Column(name = "SMS_TEXT")
	private String smsText;
	
	@Column(name = "EMAIL_SUBJECT")
	private String emailSubject;
	
	@Lob 
	@Column(name = "EMAIL_BODY")
	private String emailBody;
	
	@Column(name = "SYSTEM_NOTIFICATION_BODY")
	private String systemNotificationBody;
}
