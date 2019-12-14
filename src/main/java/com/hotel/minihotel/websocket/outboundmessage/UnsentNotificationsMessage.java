package com.informatique.gov.helpdesk.websocket.outboundmessage;

import java.io.Serializable;
import java.util.List;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.websocket.dto.SystemNotificationDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnsentNotificationsMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	List<SystemNotificationDto>  notifications;
	int totalNumberOfUnreceived;
	
}
