package com.cdac.plugngo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.plugngo.entity.ChargingLog;
import com.cdac.plugngo.entity.ChargingSlot;
import com.cdac.plugngo.service.ChargingLogService;
import com.cdac.plugngo.service.ChargingSlotService;

@RequestMapping("/api/v1")
@RestController
public class ChargingLogController {

	@Autowired
	ChargingLogService chargingLogService;
	
	@Autowired
	ChargingSlotService chargingSlotService;
	
	@GetMapping("/logs")
	public ResponseEntity<Iterable<ChargingLog>> getAllLogs() {
		return new ResponseEntity<>(chargingLogService.findAllLog(), HttpStatus.OK);
	}
	
	@PostMapping("/addLog/{id}")
	public ResponseEntity<ChargingLog> addLog(@PathVariable int id,
			@RequestBody ChargingLog chargingLog) {
		Optional<ChargingSlot> slotOpt = chargingSlotService.findSlot(id);
		ChargingSlot slot = slotOpt.get();
		
		ChargingLog log = new ChargingLog();
		log.setStart_time(chargingLog.getStart_time());
		log.setEnd_time(chargingLog.getEnd_time());
		log.setSlot(slot);
		
		slot.getChargingLogList().add(log);
		if (chargingSlotService.addSlot(slot)) {
			return new ResponseEntity<>(log, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("logs/{id}")
	public ResponseEntity<ChargingLog> getLog(@PathVariable int id) {
		return new ResponseEntity<>(chargingLogService.findLog(id).get(), HttpStatus.OK);
	}
}
