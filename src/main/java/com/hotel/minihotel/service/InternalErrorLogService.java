package com.informatique.gov.helpdesk.service;


import java.io.Serializable;

import com.informatique.gov.helpdesk.domain.ErrorLog;
import com.informatique.gov.helpdesk.exception.ShowDogException;

public interface InternalErrorLogService extends Serializable {

    ShowDogException log(ShowDogException customerServiceException);

	void log(ErrorLog errorLog);

}