package com.informatique.gov.helpdesk.websocket.dto;

import java.util.Date;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.rest.dto.UserModel;

import lombok.Data;

@Data
public class SystemNotificationDto implements UserModel<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;	
	private Long id;
	private String typeCode;
	private Date receiveDate;
	private String body;
	private Date sendDate;
	private Date createDate;
	private String TicketSerial; 
}
