package com.informatique.gov.helpdesk.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.informatique.gov.helpdesk.domain.NotificationTemplate;

@Repository
public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate, Short>{

	@Query("select nt.systemNotificationBody from NotificationTemplate nt where nt.eventCode = :eventCode")
	String findSystemNotificationBodyByEventCode(@Param("eventCode") String eventCode);
}
