package com.cdac.plugngo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.plugngo.entity.ChargingSlot;
import com.cdac.plugngo.repository.ChargingSlotRepository;

@Service
public class ChargingSlotService {

	@Autowired
	ChargingSlotRepository chargingSlotRepository;
	
	public Iterable<ChargingSlot> findAllSlot() {
		return chargingSlotRepository.findAll();
	}
	
	public boolean addSlot(ChargingSlot slot) {
		if (chargingSlotRepository.save(slot) == null) {
			return false;
		}
		return true;
	}
	
	public Optional<ChargingSlot> findSlot(int id) {
		return chargingSlotRepository.findById(id);
	}
	
	public void deleteSlot(ChargingSlot slot) {
		chargingSlotRepository.delete(slot);
	}
}
