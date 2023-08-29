package com.cdac.plugngo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.plugngo.entity.ChargingLog;
import com.cdac.plugngo.repository.ChargingLogRepository;

@Service
public class ChargingLogService {

	@Autowired
	ChargingLogRepository charginglogRepository;
	
	public Iterable<ChargingLog> findAllLog() {
		return charginglogRepository.findAll();
	}
	
	public boolean addLog(ChargingLog log) {
		if (charginglogRepository.save(log) == null) {
			return false;
		}
		return true;
	}
	
	public Optional<ChargingLog> findLog(int id) {
		return charginglogRepository.findById(id);
	}
}
