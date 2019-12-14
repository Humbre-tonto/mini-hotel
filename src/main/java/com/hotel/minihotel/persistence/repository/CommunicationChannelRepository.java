package com.informatique.gov.helpdesk.persistence.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.informatique.gov.helpdesk.domain.CommunicationChannel;

@EnableJpaRepositories
@EnableJpaAuditing
@EntityScan
@ComponentScan
@Repository
public interface CommunicationChannelRepository extends JpaRepository<CommunicationChannel, Byte> {

	CommunicationChannel findByCode(String code);

}
