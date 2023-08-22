package com.cdac.plugngo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.plugngo.entity.ChargingStations;
import com.cdac.plugngo.service.ChargingStationService;

@RestController
public class ChargingStationController {

	@Autowired 
	private ChargingStationService chargingStationService;
	
	@GetMapping("/getAllStations")
	public @ResponseBody Iterable<ChargingStations> getAllStations() {
		return chargingStationService.findAll();
	}
	
	@PostMapping("/addStation")
	public @ResponseBody String addStation(@RequestParam long contact,
			@RequestParam String name, 
			@RequestParam String address,
			@RequestParam byte[] image,
			@RequestParam int totalSlots) {
		ChargingStations cs = new ChargingStations();
		cs.setContact(contact);
		cs.setAddress(address);
		cs.setImage_data(image);
		cs.setStation_name(name);
		cs.setTotal_slots(totalSlots);
		
		if (chargingStationService.add(cs)) {
			return "Saved Successfully";
		}
		return "Not Saved";
	}
}
