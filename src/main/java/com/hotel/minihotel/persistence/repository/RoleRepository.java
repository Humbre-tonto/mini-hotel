package com.informatique.gov.helpdesk.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatique.gov.helpdesk.domain.Role;

public interface RoleRepository  extends JpaRepository<Role, Byte>{
	Role findByCode(String code);
}
