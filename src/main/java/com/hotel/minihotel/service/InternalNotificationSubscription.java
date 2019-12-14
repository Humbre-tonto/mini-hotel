package com.informatique.gov.helpdesk.service;

import java.io.Serializable;

import com.informatique.gov.helpdesk.exception.ShowDogException;

public interface InternalNotificationSubscription extends Serializable{
	void subscribe(String subscription) throws ShowDogException;
	void unsubscribe(String subscription) throws ShowDogException;
	boolean isSubscribed(String subscription) throws ShowDogException;
}
