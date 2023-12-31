package com.cdac.plugngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.plugngo.entity.ChargingStation;

@Repository
public interface ChargingStationRepository extends JpaRepository<ChargingStation, Integer> {

}
