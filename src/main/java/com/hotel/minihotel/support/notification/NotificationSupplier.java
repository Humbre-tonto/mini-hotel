package com.informatique.gov.helpdesk.support.notification;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.informatique.gov.helpdesk.domain.NotificationSubscription;
import com.informatique.gov.helpdesk.domain.SystemNotification;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.persistence.repository.NotificationSubscriptionRepository;
import com.informatique.gov.helpdesk.persistence.repository.SystemNotificationRepository;
import com.informatique.gov.helpdesk.support.modelmapper.ModelMapper;
import com.informatique.gov.helpdesk.websocket.dto.SystemNotificationDto;
import com.informatique.gov.helpdesk.websocket.outboundmessage.UnsentNotificationsMessage;

import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
public class NotificationSupplier {
	
	private SimpMessagingTemplate simpMessagingTemplate;
	private SystemNotificationRepository systemNotificationRepository;
	private NotificationSubscriptionRepository notificationSubscriptionRepository;
	private ModelMapper<SystemNotification, SystemNotificationDto, Long> systemNotificationMapper;
	
	@PostConstruct
	public void init() {
		new Thread(() ->  {
			try {
				while(true) {
					
					this.supply();
					Thread.sleep(5000);
				}
			} catch (ShowDogException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}).start();
	}
	
	
	private void supply() throws ShowDogException {
		
		try {
			
			List<NotificationSubscription> subscriptions = notificationSubscriptionRepository.findAll();
			
			for(NotificationSubscription subscription : subscriptions) {
				List<SystemNotification> notifications = systemNotificationRepository.findByRecipientAndSendDateIsNull(subscription.getSubscription());
				List<SystemNotificationDto> notificationDtos = systemNotificationMapper.toDto(notifications);
				int unreceived = systemNotificationRepository.countByRecipientAndReceiveDateIsNull(subscription.getSubscription());
				
				UnsentNotificationsMessage unsentNotificationMessage = new UnsentNotificationsMessage(notificationDtos, unreceived);
				simpMessagingTemplate.convertAndSendToUser(subscription.getSubscription(), "/queue/notifications", unsentNotificationMessage);
			}
			
			
			
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
	}
}
