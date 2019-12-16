package com.hotel.minihotel.exception;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hotel.minihotel.support.jackson.HotelExceptionSerializer;

import lombok.Getter;
import lombok.Setter;

@Getter
@JsonSerialize(using = HotelExceptionSerializer.class)
public class HotelException extends Exception implements Serializable {

	/**
	 * 
	 */
	public static final long serialVersionUID = 1;
   
    private final String code;
    private final String description;
    private final String fixSuggestion;
    @Setter
    private Long errorId;
    @Setter
    private String userLoginName;
    protected String ticketSerial;
    
    public HotelException(HotelExceptionEnum customerServiceExceptionEnum) {
        this.code = customerServiceExceptionEnum.getCode();
        this.description = customerServiceExceptionEnum.getDescription();
        this.fixSuggestion = customerServiceExceptionEnum.getFixSuggestion();
    }
    
    public HotelException(HotelExceptionEnum customerServiceExceptionEnum, Object... args) {
       
    	this.code = customerServiceExceptionEnum.getCode();
        this.description = String.format(customerServiceExceptionEnum.getDescription(), args);
        this.fixSuggestion = customerServiceExceptionEnum.getFixSuggestion();
    }

//    @ConstructorProperties({"code", "description", "fixSuggestion"})
//    public CustomerServiceException(String code, String description, String fixSuggestion) {
//        this.code = code;
//        this.description = description;
//        this.fixSuggestion = fixSuggestion;
//    }
    
    public HotelException(HotelExceptionEnum customerServiceExceptionEnum, Throwable cause) {
        super(cause);
        this.code = customerServiceExceptionEnum.getCode();
        this.description = customerServiceExceptionEnum.getDescription();
        this.fixSuggestion = customerServiceExceptionEnum.getFixSuggestion();
    }
    
//    public CustomerServiceException(String code, String description, String fixSuggestion, Throwable cause) {
//        super(cause);
//        this.code = code;
//        this.description = description;
//        this.fixSuggestion = fixSuggestion;
//    }

    public String toString() {

        //TODO : need to be revisited, causes StackOverFlowError on some cases
        return new StringBuilder()
                .append("ErrorId : ").append(getErrorId()).append("-->>\n\r")
                .append("ErrorCode : ").append(getCode()).append("-->>\n\r")
                .append("caseSerial : ").append(getTicketSerial()).append("-->>\n\r")
                .append("UserLoginName : ").append(getUserLoginName()).append("-->>\n\r")
                .append("Description : ").append(this.getDescription()).toString();
    }
}
