package com.informatique.gov.helpdesk.persistence.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.informatique.gov.helpdesk.domain.SystemNotification;

@Repository
public interface SystemNotificationRepository extends JpaRepository<SystemNotification, Long>{
	
	@Modifying
	@Query("update SystemNotification sn set sn.sendDate = :sendDate where sn.id = :id")
	void updateSendDateById(@Param("id") Long id, @Param("sendDate")  Date sendDate);
	
	List<SystemNotification> findByRecipientAndSendDateIsNull(String recipient);

	
	@Query("select count(sn) from SystemNotification sn where sn.recipient = :recipient and sn.receiveDate is null")
	int countByRecipientAndReceiveDateIsNull( @Param("recipient") String recipient);
	
	
	
	Page<SystemNotification> findByRecipient(String recipient, Pageable pageable);
	
	List<SystemNotification> findByRecipient(String recipient);

	
	/*@Query(value = "select sn.id,             " + 
			"       sn.create_by,             " + 
			"       sn.create_date,           " + 
			"       sn.BODY,                  " + 
			"       sn.RECEIVE_DATE,          " + 
			"       sn.RECIPIENT,             " + 
			"       sn.SEND_DATE,             " + 
			"       sn.TYPE_CODE,             " + 
			"  from SYSTEM_NOTIFICATION sn    " + 
			" where sn.RECIPIENT = :recipient " + 
			" order by :orderBy :direction offset :page rows fetch next :size rows only ", nativeQuery = true)
	List<SystemNotification> findByRecipient(@Param("recipient") String recipient, @Param("page") int page, @Param("size") int size, @Param("orderBy") List<String> orderBy, @Param("direction") String direction);
	*/
	
	
	@Modifying
	@Query("update SystemNotification sn set sn.receiveDate = :receiveDate where sn.id in (:ids)")
	void updateReceiveDateByIds(@Param("ids") List<Long> ids, @Param("receiveDate")  Date receiveDate);
}
