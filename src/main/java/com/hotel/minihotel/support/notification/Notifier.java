package com.informatique.gov.helpdesk.support.notification;

import java.io.Serializable;
import java.util.List;

import com.informatique.gov.helpdesk.domain.EmailNotification;
import com.informatique.gov.helpdesk.domain.SmsNotification;
import com.informatique.gov.helpdesk.exception.ShowDogException;



public interface Notifier extends Serializable{
	
	boolean supports(Class<?> clazz);
	default void notifyBySystem(Object object) throws ShowDogException {
		
	}
	
	default List<EmailNotification> notifyByEmail(Object object) throws ShowDogException {
		return null;
	}
	
	default List<SmsNotification> notifyBySms(Object object) throws ShowDogException {
		return null;
	}
}
