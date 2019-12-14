package com.informatique.gov.helpdesk.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatique.gov.helpdesk.domain.PetImage;

@Repository
public interface PetImageRepository extends JpaRepository<PetImage, Integer> {

	List<PetImage> findAllByPetId(Integer petId);

}
