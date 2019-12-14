package com.informatique.gov.helpdesk.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatique.gov.helpdesk.domain.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

	List<Pet> findAllByPetTypeBreedId(Integer breedId);

}
