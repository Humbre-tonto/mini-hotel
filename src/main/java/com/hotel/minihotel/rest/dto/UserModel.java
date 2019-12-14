package com.informatique.gov.helpdesk.rest.dto;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public interface UserModel<T extends Serializable> extends Serializable{
	T getId();
	void setId(T id);
}
