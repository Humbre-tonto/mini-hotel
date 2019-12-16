package com.hotel.minihotel.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "error_log")
@Data
public class ErrorLog implements Serializable {

	private static final long serialVersionUID = 1;

	@Id
	@SequenceGenerator(name = "ErrorLogSequence", sequenceName = "ERROR_LOG_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ErrorLogSequence")
	@Column(name = "id")
	private Long id;

	@Lob
	@Column(name = "STACK_TRACE")
	private String stackTrace;

	@Column(name = "TICKET_SERIAL")
	private String ticketSerial;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "CREATE_DATE")
	private Date createDate;
}
