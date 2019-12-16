package com.hotel.minihotel.service;


import java.io.Serializable;

import com.hotel.minihotel.domain.ErrorLog;
import com.hotel.minihotel.exception.HotelException;

public interface InternalErrorLogService extends Serializable {

    HotelException log(HotelException hotelException);

	void log(ErrorLog errorLog);

}