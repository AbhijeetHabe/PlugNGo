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

import com.cdac.plugngo.entity.ChargingStation;
import com.cdac.plugngo.service.ChargingStationService;

@RequestMapping("/api/v1")
@RestController
public class ChargingStationController {

	@Autowired 
	private ChargingStationService chargingStationService;
	
	@GetMapping("/stations")
	public ResponseEntity<Iterable<ChargingStation>> getAllStations() {
		return new ResponseEntity<>(chargingStationService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/addStation")
	public ResponseEntity<ChargingStation> addStation(@RequestBody ChargingStation chargingStation) {
		ChargingStation cs = new ChargingStation();
		cs.setContact(chargingStation.getContact());
		cs.setAddress(chargingStation.getAddress());
		cs.setImage_data(chargingStation.getImage_data());
		cs.setStation_name(chargingStation.getStation_name());
		
		if (chargingStationService.addStation(cs)) {
			return new ResponseEntity<>(cs, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/stations/{id}")
	public ResponseEntity<ChargingStation> getStation(@PathVariable int id) {
		return new ResponseEntity<>(chargingStationService.findStation(id).get(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStation/{id}")
	public ResponseEntity<ChargingStation> deleteStation(@PathVariable int id) {
		ChargingStation station = chargingStationService.findStation(id).get();
		chargingStationService.deleteStation(station);
		return new ResponseEntity<>(station, HttpStatus.OK);
	}
	
	@PutMapping("updateStation/{id}")
	public ResponseEntity<ChargingStation> updateStation(@PathVariable int id, @RequestBody ChargingStation station) {
		Optional<ChargingStation> stOpt = chargingStationService.findStation(id);
		if (stOpt.isPresent()) {
			ChargingStation st = stOpt.get();
			st.setAddress(station.getAddress());
			st.setContact(station.getContact());
			st.setImage_data(station.getImage_data());
			st.setStation_name(station.getStation_name());
			
			if (chargingStationService.addStation(st)) {
				return new ResponseEntity<>(station, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
}
