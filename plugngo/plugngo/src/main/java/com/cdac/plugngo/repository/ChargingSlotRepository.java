package com.cdac.plugngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.plugngo.entity.ChargingSlot;

@Repository
public interface ChargingSlotRepository extends JpaRepository<ChargingSlot, Integer> {

}
