package com.hotel.minihotel.support.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.exception.HotelExceptionEnum;
import com.hotel.minihotel.exception.HotelInternalException;


public class HotelExceptionSerializer extends StdSerializer<HotelException> {

	private static final long serialVersionUID = HotelException.serialVersionUID;

	public HotelExceptionSerializer() {
		this(null);
	}

	public HotelExceptionSerializer(Class<HotelException> t) {
		super(t);
	}

	protected HotelExceptionSerializer(Class<HotelException> t, boolean dummy) {
		super(t, dummy);
	}

	@Override
	public void serialize(HotelException customerServiceException, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException {

		jsonGenerator.writeStartObject();
		if (customerServiceException instanceof HotelInternalException) {
			
			if(customerServiceException.getErrorId() != null) {
				jsonGenerator.writeNumberField("errorId", customerServiceException.getErrorId());
			}
			
			jsonGenerator.writeStringField("errorCode", HotelExceptionEnum.INTERNAL_EXCEPTION.getCode());
						

		} else {
			
			jsonGenerator.writeStringField("errorCode", customerServiceException.getCode());
			
			if (customerServiceException.getDescription() != null) {
				jsonGenerator.writeStringField("errorDescription", customerServiceException.getDescription());
			}

			if (customerServiceException.getFixSuggestion() != null) {
				jsonGenerator.writeStringField("fixSuggestion", customerServiceException.getFixSuggestion());
			}
			
			if (customerServiceException.getTicketSerial() != null) {
				jsonGenerator.writeStringField("caseSerial", customerServiceException.getTicketSerial());
			}

		}
		jsonGenerator.writeEndObject();
	}
}
