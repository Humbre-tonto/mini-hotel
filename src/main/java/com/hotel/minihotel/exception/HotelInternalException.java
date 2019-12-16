package com.hotel.minihotel.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class HotelInternalException extends HotelException{


    /**
	 * 
	 */
	private static final long serialVersionUID = 1;

	public HotelInternalException(String message) {
        super(HotelExceptionEnum.INTERNAL_EXCEPTION, new Exception(message));
    }

    public HotelInternalException(Throwable throwable) {
        super(HotelExceptionEnum.INTERNAL_EXCEPTION, throwable);
    }
    
    public HotelInternalException(String ticketSerial, Throwable throwable) {
        super(HotelExceptionEnum.INTERNAL_EXCEPTION, throwable);
        this.ticketSerial = ticketSerial;
    }
    
    protected HotelInternalException(HotelExceptionEnum customerServiceExceptionEnum, Object... args) {
        super(customerServiceExceptionEnum, args);
    }
    
    public String toString() {

        //TODO : need to be revisited, causes StackOverFlowError on some cases
        return new StringBuilder()
                .append("ErrorId : ").append(getErrorId()).append("-->>\n\r")
                .append("ErrorCode : ").append(getCode()).append("-->>\n\r")
                .append("CaseSerial : ").append(getTicketSerial()).append("-->>\n\r")
                .append("UserLoginName : ").append(getUserLoginName()).append("-->>\n\r")
                .append("StackTrace : ").append(this.getCause() != null ? ExceptionUtils.getStackTrace(this.getCause()) : this.getDescription())
                .toString();

    }


}
