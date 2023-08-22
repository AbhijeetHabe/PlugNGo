package com.cdac.plugngo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdac.plugngo.entity.ChargingStations;

@Repository
public interface ChargingStationRepository extends CrudRepository<ChargingStations, Long> {

}
