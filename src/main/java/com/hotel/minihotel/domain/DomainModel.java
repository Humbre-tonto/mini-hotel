package com.hotel.minihotel.domain;

import java.io.Serializable;

public interface DomainModel<T extends Serializable> extends Serializable{
	T getId();
	void setId(T id);
}

