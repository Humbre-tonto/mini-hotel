package com.informatique.gov.helpdesk.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.SystemNotification;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.persistence.repository.SystemNotificationRepository;
import com.informatique.gov.helpdesk.service.SystemNotificationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class SystemNotificationServiceImpl implements SystemNotificationService{
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	private SystemNotificationRepository systemNotificationRepository;
	
	@Override
	public void setSendDate(Long id) throws ShowDogException{
		
		try {
			systemNotificationRepository.updateSendDateById(id, new Date());
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
	}

	@Override
	public Page<SystemNotification> getByRecipient(String recipient, Pageable pageable) throws ShowDogException{
		Page<SystemNotification> notifications = null;
		try {
			notifications = systemNotificationRepository.findByRecipient(recipient, pageable);
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return notifications;
	}
	
	@Override
	public void markAsSeen(List<SystemNotification> notifications) throws ShowDogException{
		try {
			List<Long> ids = notifications.stream().map((notification) -> notification.getId()).collect(Collectors.toList());
			systemNotificationRepository.updateReceiveDateByIds(ids, new Date());
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
	}

	@Override
	public List<SystemNotification> getTotalByRecipient(String recipient) throws ShowDogException {
		List<SystemNotification> notifications = null;
		try {
			notifications = systemNotificationRepository.findByRecipient(recipient);
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return notifications;
	}
}
