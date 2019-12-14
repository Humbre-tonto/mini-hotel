package com.informatique.gov.helpdesk.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatique.gov.helpdesk.domain.ErrorLog;



@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long>{
}
