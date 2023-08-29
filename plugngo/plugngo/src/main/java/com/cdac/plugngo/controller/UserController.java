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

import com.cdac.plugngo.entity.User;
import com.cdac.plugngo.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() {
		return new ResponseEntity<> (userService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User us = new User();
		us.setUser_contact(user.getUser_contact());
		us.setUser_location(user.getUser_location());
		us.setUser_name(user.getUser_name());
		
		if (userService.addUser(us)) {
			return new ResponseEntity<>(us, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) {
		return new ResponseEntity<>(userService.findUser(id).get(), HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
		Optional<User> usOpt = userService.findUser(id);
		if (usOpt.isPresent()) {
			User us = usOpt.get();
			us.setUser_contact(user.getUser_contact());
			us.setUser_location(user.getUser_location());
			us.setUser_name(user.getUser_name());
			
			if (userService.addUser(us)) {
				return new ResponseEntity<>(us, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		User user = userService.findUser(id).get();
		userService.deleteUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
