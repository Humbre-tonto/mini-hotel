package com.hotel.minihotel.service.impl;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.minihotel.domain.ErrorLog;
import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.persistence.repository.ErrorLogRepository;
import com.hotel.minihotel.service.InternalErrorLogService;
import com.hotel.minihotel.service.InternalSecurityService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ErrorLogServiceImpl implements InternalErrorLogService {

    private static final long serialVersionUID = 1;
    private final Logger logger = LoggerFactory.getLogger(ErrorLogServiceImpl.class);
    private InternalSecurityService securityService;
    private ErrorLogRepository errorLogRepository;


    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public HotelException log(HotelException helpdeskException){
        ErrorLog errorLog = null;
        Long errorId = null;

        try{

        	if(helpdeskException.getUserLoginName() == null) {
        		helpdeskException.setUserLoginName(securityService.getPrincipal());
        	}

            errorLog = new ErrorLog();
            errorLog.setCreateDate(new Date());
            errorLog.setUserName(helpdeskException.getUserLoginName());
            errorLog.setTicketSerial(helpdeskException.getTicketSerial());
            errorLog.setStackTrace(helpdeskException.toString());

            errorLog = errorLogRepository.save(errorLog);

            errorId = errorLog.getId();


            helpdeskException.setErrorId(errorId);

            logger.error("", helpdeskException);
        }catch(Exception e){
      
            logger.error("Error while persisting exception : ", e, helpdeskException);
        }

        return helpdeskException;
    }
    
    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void log(ErrorLog errorLog){
        
       

        try{

        	errorLog.setCreateDate(new Date());
            if(errorLog.getUserName() == null) {
            	errorLog.setUserName(securityService.getPrincipal());
            }
           errorLog = errorLogRepository.save(errorLog);

        }catch(Exception e){
        	
        	logger.error("Error while persisting exception : ", e);
        }
    }
}