package com.informatique.gov.helpdesk.support.aspect;

import java.io.Serializable;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.support.annotation.NotifiableEvent;
import com.informatique.gov.helpdesk.support.notification.NotifierDelegate;

import lombok.AllArgsConstructor;

@Aspect
@Component
@AllArgsConstructor
public class NotificationControlAspect implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private final Logger logger = LoggerFactory.getLogger(NotificationControlAspect.class);
	private NotifierDelegate notifierDelegate;
	
	@Pointcut(value = "execution(public * com.informatique.gov.helpdesk.rest.handler.impl..*(..))")
	public void anyHandlerPublicMethod() {
	}
	
	@Around("anyHandlerPublicMethod() && @annotation(notifiableEvent)")
	public Object handleNotifiableEvent(ProceedingJoinPoint pjp, NotifiableEvent notifiableEvent) throws ShowDogException {
		
		try {
			Object object = pjp.proceed();
			
			ResponseEntity<?> responseEntity  = (ResponseEntity<?>)object;
			Object body = responseEntity.getBody();
			
			notifierDelegate.Notify(body, notifiableEvent);
			
			return object;
		} catch (ShowDogException e) {
			throw e;
		} catch (Throwable e) {
			throw new HelpdeskInternalException(e);
		}
	}
}
