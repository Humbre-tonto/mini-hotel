package com.hotel.minihotel.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.minihotel.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	List<Room> findAll();

	Optional<Room> findById(Integer id);
}
