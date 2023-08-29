package com.cdac.plugngo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.plugngo.entity.ChargingSlot;
import com.cdac.plugngo.entity.ChargingStation;
import com.cdac.plugngo.service.ChargingSlotService;
import com.cdac.plugngo.service.ChargingStationService;

@RequestMapping("/api/v1")
@RestController
public class ChargingSlotController {

	@Autowired
	ChargingSlotService chargingSlotService;
	
	@Autowired
	ChargingStationService chargingStationService;
	
	@GetMapping("/slots")
	public ResponseEntity<Iterable<ChargingSlot>> getAllSlots() {
		return new ResponseEntity<>(chargingSlotService.findAllSlot(), HttpStatus.OK);
	}
	
	@PostMapping("/addSlot/{id}")
	public ResponseEntity<ChargingSlot> addSlot(@PathVariable int id,
			@RequestBody ChargingSlot chargingSlot) {
		Optional<ChargingStation> stationOpt = chargingStationService.findStation(id);
		ChargingStation station = stationOpt.get();
		
		ChargingSlot slot = new ChargingSlot();
		slot.setAvailability(chargingSlot.getAvailability());
		slot.setCharging_time(chargingSlot.getCharging_time());
		slot.setStation(station);
		
		station.getChargingSlotList().add(slot);
		
		if (chargingStationService.addStation(station)) { 
			return new ResponseEntity<>(slot, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/slots/{id}")
	public ResponseEntity<ChargingSlot> getSlot(@PathVariable int id) {
		return new ResponseEntity<>(chargingSlotService.findSlot(id).get(), HttpStatus.OK);
	}
	
	@DeleteMapping("deleteSlot/{id}")
	public ResponseEntity<ChargingSlot> deleteSlot(@PathVariable int id) {
		ChargingSlot slot = chargingSlotService.findSlot(id).get();
		chargingSlotService.deleteSlot(slot);
		return new ResponseEntity<>(slot, HttpStatus.OK);
	}
	
	@PutMapping("updateSlot/{id}")
	public ResponseEntity<ChargingSlot> updateSlot(@PathVariable int id, @RequestBody ChargingSlot slot) {
		Optional<ChargingSlot> slotOpt = chargingSlotService.findSlot(id);
		if (slotOpt.isPresent()) {
			ChargingSlot slt = slotOpt.get();
			slt.setAvailability(slot.getAvailability());
			slt.setCharging_time(slot.getCharging_time());
			if (chargingSlotService.addSlot(slt)) {
				return new ResponseEntity<>(slt, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
}
