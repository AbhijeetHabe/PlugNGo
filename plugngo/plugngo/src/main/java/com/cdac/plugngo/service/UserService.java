package com.cdac.plugngo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.plugngo.entity.User;
import com.cdac.plugngo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public boolean addUser(User user) {
		if (userRepository.save(user) == null) {
			return false;
		}
		return true;
	}
	
	public Optional<User> findUser(int id) {
		return userRepository.findById(id);
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
}
