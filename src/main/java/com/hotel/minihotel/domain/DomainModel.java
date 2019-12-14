package com.informatique.gov.helpdesk.domain;

import java.io.Serializable;

public interface DomainModel<T extends Serializable> extends Serializable{
	T getId();
	void setId(T id);
}

