package com.informatique.gov.helpdesk.rest.handler;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.informatique.gov.helpdesk.exception.ShowDogException;

public interface CommunicationChannelHandler extends Serializable{

	ResponseEntity<List<?>> getAll() throws ShowDogException;

}
