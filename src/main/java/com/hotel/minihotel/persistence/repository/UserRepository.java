package com.informatique.gov.helpdesk.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.informatique.gov.helpdesk.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@EntityGraph(value = "User.fat", type = EntityGraphType.FETCH)
	User findByLoginNameIgnoreCase(String loginName);

	@Query("from User u where lower(u.loginName) = lower(:loginName)")
	Optional<User> findThinByLoginNameIgnoreCase(@Param("loginName") String loginName);

	@Query("select id from User u where u.id != :id and u.loginName=:loginName")
	Integer findIdByLoginNameAndNotEqualId(@Param("loginName") String loginName, @Param("id") Integer id);

	@Query("select id from User u where u.loginName=:loginName")
	Integer findIdByLoginName(@Param("loginName") String loginName);

	@EntityGraph(value = "User.fat", type = EntityGraphType.FETCH)
	List<User> findAll();

	@EntityGraph(value = "User.fat", type = EntityGraphType.FETCH)
	Optional<User> findById(Integer id);

	@Query("select u.role.code from User u where u.loginName = :loginName")
	Optional<String> findRoleCodeByLoginName(@Param("loginName") String loginName);


	//@Query("select u from User u inner join OrganizationUnit ou on(u.organizationUnit.id = ou.id) inner join Queue q on(q.organizationUnitCode = ou.code) where q.code = :code")
	//List<User> findByQueueCode(@Param("code") String code);

//	@Query("select u from User u inner join OrganizationUnit ou on(u.organizationUnit.id = ou.id) inner join Queue q on(q.organizationUnitCode = ou.code) where q.code = :code and u.role.id!=:id")
//	List<User> findAllAgents(@Param("code") String code, @Param("id") Byte id);


}
