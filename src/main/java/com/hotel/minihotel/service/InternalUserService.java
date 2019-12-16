package com.hotel.minihotel.service;

import java.io.Serializable;

import com.hotel.minihotel.domain.User;
import com.hotel.minihotel.exception.HotelException;


public interface InternalUserService extends Serializable{

	User getByLoginName(String loginName) throws HotelException;

}
