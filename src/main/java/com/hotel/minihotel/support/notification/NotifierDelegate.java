package com.informatique.gov.helpdesk.support.notification;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.service.InternalErrorLogService;
import com.informatique.gov.helpdesk.support.annotation.NotifiableEvent;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class NotifierDelegate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private InternalErrorLogService errorLogService;
	private List<Notifier> notifiers;

	public void Notify(Object object, NotifiableEvent notifiableEvent) throws ShowDogException {

		new Thread(() -> {
			
			try {
				for (Notifier notifier : notifiers) {
					if (notifier.supports(object.getClass())) {

						if (notifiableEvent.system()) {
							
							new Thread(() -> {
								try {
									notifier.notifyBySystem(object);
								} catch (ShowDogException e) {
									errorLogService.log(e);
								}
							}).start();
							
						}

						if (notifiableEvent.sms()) {
							new Thread(() -> {
								try {
									notifier.notifyBySms(object);
								} catch (ShowDogException e) {
									errorLogService.log(e);
								}
							}).start();
						}

						if (notifiableEvent.email()) {
							new Thread(() -> {
								try {
									notifier.notifyByEmail(object);
								} catch (ShowDogException e) {
									errorLogService.log(e);
								}
							}).start();
							
						}
					}
				}
			} catch (Exception e) {
				errorLogService.log(new HelpdeskInternalException(e));
			}
			
		}).start();
	}
}
