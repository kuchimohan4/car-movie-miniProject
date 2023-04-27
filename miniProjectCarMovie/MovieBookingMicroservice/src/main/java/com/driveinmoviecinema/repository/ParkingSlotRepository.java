package com.driveinmoviecinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driveinmoviecinema.models.ParkingSlot;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer> {

}
