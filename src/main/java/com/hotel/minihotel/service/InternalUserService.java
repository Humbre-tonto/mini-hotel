package com.informatique.gov.helpdesk.service;

import java.io.Serializable;

import com.informatique.gov.helpdesk.domain.User;
import com.informatique.gov.helpdesk.exception.ShowDogException;


public interface InternalUserService extends Serializable{

	User getByLoginName(String loginName) throws ShowDogException;

}
