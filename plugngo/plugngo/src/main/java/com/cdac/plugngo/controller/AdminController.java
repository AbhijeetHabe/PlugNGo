package com.cdac.plugngo.controller;

import java.util.List;
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

import com.cdac.plugngo.entity.Admin;
import com.cdac.plugngo.service.AdminService;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAllAdmin() {
		return new ResponseEntity<> (adminService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addUser(@RequestBody Admin admin) {
		Admin ad = new Admin();
		ad.setAdmin_contact(admin.getAdmin_contact());
		ad.setAdmin_location(admin.getAdmin_location());
		ad.setAdmin_name(admin.getAdmin_name());
		
		if (adminService.addAdmin(ad)) {
			return new ResponseEntity<>(ad, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/admins/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable int id) {
		return new ResponseEntity<>(adminService.findUser(id).get(), HttpStatus.OK);
	}
	
	@PutMapping("/updateAdmin/{id}")
	public ResponseEntity<Admin> updateUser(@PathVariable int id, @RequestBody Admin admin) {
		Optional<Admin> adOpt = adminService.findUser(id);
		if (adOpt.isPresent()) {
			Admin ad = adOpt.get();
			ad.setAdmin_contact(admin.getAdmin_contact());
			ad.setAdmin_location(admin.getAdmin_location());
			ad.setAdmin_name(admin.getAdmin_name());
			
			if (adminService.addAdmin(ad)) {
				return new ResponseEntity<>(ad, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<Admin> deleteUser(@PathVariable int id) {
		Admin admin = adminService.findUser(id).get();
		adminService.deleteUser(admin);
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
}
