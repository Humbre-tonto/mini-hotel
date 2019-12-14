package com.informatique.gov.helpdesk.support.applicationlistner;

import java.security.Principal;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.service.InternalNotificationSubscription;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class StompSubscribeEventListener implements ApplicationListener<SessionSubscribeEvent> {
	
	private InternalNotificationSubscription notificationSubscription;
	
	@Override
	public void onApplicationEvent(SessionSubscribeEvent event) {
		try {
			Message<?> message = event.getMessage();
			StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
			Principal principal = accessor.getUser();
	    	
			if(principal instanceof Authentication) {
				String  subscription = ((Authentication)principal).getPrincipal().toString();
				notificationSubscription.subscribe(subscription);
			}
		}catch(ShowDogException e) {
			
		} catch(Exception e) {
			
		}
		
	}

}
