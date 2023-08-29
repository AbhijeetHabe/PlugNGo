package com.cdac.plugngo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.plugngo.entity.ChargingStation;
import com.cdac.plugngo.repository.ChargingStationRepository;

@Service
public class ChargingStationService {

	@Autowired
	private ChargingStationRepository chargingStationRepository;
	
	public Iterable<ChargingStation> findAll() {
		return chargingStationRepository.findAll();
	}
	
	public boolean addStation(ChargingStation station) {
		if (chargingStationRepository.save(station) == null) {
			return false;
		}
		return true;
	}
	
	public Optional<ChargingStation> findStation(int id) {
		return chargingStationRepository.findById(id);
	}
	
	public void deleteStation(ChargingStation station) {
		chargingStationRepository.delete(station);
	}
}
