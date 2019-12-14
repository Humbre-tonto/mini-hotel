package com.informatique.gov.helpdesk.support.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.ShowDogExceptionEnum;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;


public class HelpdeskExceptionSerializer extends StdSerializer<ShowDogException> {

	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	public HelpdeskExceptionSerializer() {
		this(null);
	}

	public HelpdeskExceptionSerializer(Class<ShowDogException> t) {
		super(t);
	}

	protected HelpdeskExceptionSerializer(Class<ShowDogException> t, boolean dummy) {
		super(t, dummy);
	}

	@Override
	public void serialize(ShowDogException customerServiceException, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException {

		jsonGenerator.writeStartObject();
		if (customerServiceException instanceof HelpdeskInternalException) {
			
			if(customerServiceException.getErrorId() != null) {
				jsonGenerator.writeNumberField("errorId", customerServiceException.getErrorId());
			}
			
			jsonGenerator.writeStringField("errorCode", ShowDogExceptionEnum.INTERNAL_EXCEPTION.getCode());
						

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
