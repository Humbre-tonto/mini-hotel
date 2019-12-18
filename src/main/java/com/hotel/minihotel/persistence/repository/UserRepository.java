package com.hotel.minihotel.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotel.minihotel.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@EntityGraph(value = "User.fat", type = EntityGraphType.FETCH)
	List<User> findAll();

	@EntityGraph(value = "User.fat", type = EntityGraphType.FETCH)
	Optional<User> findById(Integer id);
	@EntityGraph(value = "User.fat", type = EntityGraphType.FETCH)
	Optional<User> findByRoleCode(Integer id);
	@Query("select u.role.code from User u where u.name = :loginName")
	Optional<String> findRoleCodeByLoginName(@Param("loginName") String loginName);
	@EntityGraph(value = "User.fat", type = EntityGraphType.FETCH)
	User findByName(String loginName);

	User findByNameAndPassword(String id, String password);

}
