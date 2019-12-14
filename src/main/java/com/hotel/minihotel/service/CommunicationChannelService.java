package com.informatique.gov.helpdesk.service;

import java.io.Serializable;
import java.util.List;

import com.informatique.gov.helpdesk.domain.CommunicationChannel;
import com.informatique.gov.helpdesk.exception.ShowDogException;

public interface CommunicationChannelService extends Serializable {
	List<CommunicationChannel> getAll() throws ShowDogException;

}