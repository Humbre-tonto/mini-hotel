package com.informatique.gov.helpdesk.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.CommunicationChannel;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.persistence.repository.CommunicationChannelRepository;
import com.informatique.gov.helpdesk.service.CommunicationChannelService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CommunicationChannelServiceImpl implements CommunicationChannelService {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private CommunicationChannelRepository communicationChannelRepository;

	@Override
	public List<CommunicationChannel> getAll() throws ShowDogException {
		List<CommunicationChannel> communicationChannels = null;
		try {
			communicationChannels = communicationChannelRepository.findAll();
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return communicationChannels;
	}

}