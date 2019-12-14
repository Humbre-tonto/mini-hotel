package com.informatique.gov.helpdesk.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatique.gov.helpdesk.domain.NotificationSubscription;

@Repository
public interface NotificationSubscriptionRepository extends JpaRepository<NotificationSubscription, String>{

}
