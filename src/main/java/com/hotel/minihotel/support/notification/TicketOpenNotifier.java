package com.informatique.gov.helpdesk.support.notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.SystemNotification;
import com.informatique.gov.helpdesk.domain.User;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.persistence.repository.NotificationTemplateRepository;
import com.informatique.gov.helpdesk.persistence.repository.SystemNotificationRepository;
import com.informatique.gov.helpdesk.persistence.repository.UserRepository;
import com.informatique.gov.helpdesk.service.InternalSecurityService;
import com.informatique.gov.helpdesk.support.dataenum.NotifiableEventEnum;
import com.informatique.gov.helpdesk.support.dataenum.SystemNotificationTypeEnum;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
public class TicketOpenNotifier implements Notifier {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private InternalSecurityService secueityService;
	private NotificationTemplateRepository notificationTemplateRepository;
	private SystemNotificationRepository systemNotificationRepository;
	private UserRepository userRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return (Boolean) null; //TicketDto.class.equals(clazz);
	}

	@Override
	public void notifyBySystem(Object object) throws ShowDogException {
		
		try {
//
//		//	TicketDto ticketDto = (TicketDto) object;
//
//			String bodyTemplate = notificationTemplateRepository
//					.findSystemNotificationBodyByEventCode(NotifiableEventEnum.TICKET_OPEN.name());
//
//			if(StringUtils.hasText(bodyTemplate)) {
//				final String body = String.format(bodyTemplate, ticketDto.getSerial(),
//						ticketDto.getSeverityLevel().getArabicName(), ticketDto.getMaxResponseHours());
//
//				String queueCode = ticketDto.getQueue().getCode();
//				List<User> recipients = userRepository.findByQueueCode(queueCode);
//
//				
//				List<SystemNotification> notifications = new ArrayList<>();
//				recipients.stream().map(User::getLoginName).forEach(recipient -> {
//					try {
//						SystemNotification systemNotification = new SystemNotification();
//						systemNotification.setBody(body);
//						systemNotification.setCreateBy(secueityService.getPrincipal());
//						systemNotification.setCreateDate(new Date());
//						systemNotification.setRecipient(recipient);
//						systemNotification.setTypeCode(SystemNotificationTypeEnum.URGENT.getCode());
//						systemNotification.setTicketSerial(ticketDto.getSerial());
//						notifications.add(systemNotification);
//					} catch (HelpdeskException e) {
//						throw new RuntimeException(e);
//					}
//				});
//
//				systemNotificationRepository.saveAll(notifications);
//				
//			}
//			
		} catch (RuntimeException e) {
			if (e.getCause() instanceof ShowDogException) {
				throw (ShowDogException) e.getCause();
			}

			throw new HelpdeskInternalException(e);
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		
	}
}
