package com.informatique.gov.helpdesk.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatique.gov.helpdesk.domain.PetTypeBreed;

@Repository
public interface PetBreedRepository extends JpaRepository<PetTypeBreed, Integer> {

	List<PetTypeBreed> findAllByPetTypeId(Integer petTypeId);

}
