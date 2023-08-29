package com.cdac.plugngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.plugngo.entity.ChargingLog;

@Repository
public interface ChargingLogRepository extends JpaRepository<ChargingLog, Integer> {

}
