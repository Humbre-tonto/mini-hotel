package com.informatique.gov.helpdesk.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.NotificationSubscription;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.persistence.repository.NotificationSubscriptionRepository;
import com.informatique.gov.helpdesk.service.InternalNotificationSubscription;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class NotificationSubscriptionImpl implements InternalNotificationSubscription{
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	private NotificationSubscriptionRepository notificationSubscriptionRepository;
	
	@Override
	public void subscribe(String subscription) throws ShowDogException{
		try {
			NotificationSubscription notificationSubscription = new NotificationSubscription(subscription);
			notificationSubscriptionRepository.save(notificationSubscription);
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
		
	}

	@Override
	public void unsubscribe(String subscription) throws ShowDogException{
		try {
			notificationSubscriptionRepository.deleteById(subscription);
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
	}
	
	@Override
	public boolean isSubscribed(String subscription) throws ShowDogException{
		boolean isSubscribed = false;
		try {
			isSubscribed = notificationSubscriptionRepository.existsById(subscription);
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return isSubscribed;
	}

}
