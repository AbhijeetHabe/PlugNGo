package com.cdac.plugngo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.plugngo.entity.ChargingStations;
import com.cdac.plugngo.repository.ChargingStationRepository;

@Service
public class ChargingStationService {

	@Autowired
	private ChargingStationRepository chargingStationRepository;
	
	public Iterable<ChargingStations> findAll() {
		return chargingStationRepository.findAll();
	}
	
	public boolean add(ChargingStations station) {
		if (chargingStationRepository.save(station) == null) {
			return false;
		}
		return true;
	}
}
