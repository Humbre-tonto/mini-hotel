package com.hotel.minihotel.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.minihotel.domain.ErrorLog;



@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long>{
}
