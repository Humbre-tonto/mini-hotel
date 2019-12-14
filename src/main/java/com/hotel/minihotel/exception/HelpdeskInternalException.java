package com.informatique.gov.helpdesk.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.informatique.gov.helpdesk.ShowDogVersion;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class HelpdeskInternalException extends ShowDogException{


    /**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	public HelpdeskInternalException(String message) {
        super(ShowDogExceptionEnum.INTERNAL_EXCEPTION, new Exception(message));
    }

    public HelpdeskInternalException(Throwable throwable) {
        super(ShowDogExceptionEnum.INTERNAL_EXCEPTION, throwable);
    }
    
    public HelpdeskInternalException(String ticketSerial, Throwable throwable) {
        super(ShowDogExceptionEnum.INTERNAL_EXCEPTION, throwable);
        this.ticketSerial = ticketSerial;
    }
    
    protected HelpdeskInternalException(ShowDogExceptionEnum customerServiceExceptionEnum, Object... args) {
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
