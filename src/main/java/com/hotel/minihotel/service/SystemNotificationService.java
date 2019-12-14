package com.informatique.gov.helpdesk.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.informatique.gov.helpdesk.domain.SystemNotification;
import com.informatique.gov.helpdesk.exception.ShowDogException;

public interface SystemNotificationService extends Serializable{

	void setSendDate(Long id) throws ShowDogException;
	
	Page<SystemNotification> getByRecipient(String recipient, Pageable pageable) throws ShowDogException;

	void markAsSeen(List<SystemNotification> notifications) throws ShowDogException;

	List<SystemNotification> getTotalByRecipient(String principal)throws ShowDogException;

}
