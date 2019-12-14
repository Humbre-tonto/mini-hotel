package com.informatique.gov.helpdesk.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatique.gov.helpdesk.domain.SystemNotificationType;

@Repository
public interface SystemNotificationTypeRepository extends JpaRepository<SystemNotificationType, Byte>{

	SystemNotificationType findByCode(String code);
	
}
