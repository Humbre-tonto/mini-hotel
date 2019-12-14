package com.informatique.gov.helpdesk.domain;

import java.util.Date;

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
@Table(name = "SYSTEM_NOTIFICATION")
@Data
@ToString(of = { "id"})
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class SystemNotification extends CreationAuditableDomainEntity<Long, String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	@Id
	@SequenceGenerator(name = "SystemNotificationSequence", sequenceName = "SYSTEM_NOTIFICATION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SystemNotificationSequence")
	@Column(name = "id")
	private Long id;
	
	
	@Column(name = "TYPE_CODE")
	private String typeCode;
	
	@Column(name = "RECIPIENT")
	private String recipient;
	
	@Column(name = "RECEIVE_DATE")
	private Date receiveDate;
	
	@Column(name = "BODY")
	private String body;
	
	@Column(name = "SEND_DATE")
	private Date sendDate;
	
	@Column(name = "TICKET_SERIAL")
	private String ticketSerial;
}
