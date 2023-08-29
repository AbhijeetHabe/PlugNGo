package com.cdac.plugngo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.plugngo.entity.Admin;
import com.cdac.plugngo.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}
	
	public boolean addAdmin(Admin admin) {
		if (adminRepository.save(admin) == null) {
			return false;
		}
		return true;
	}
	
	public Optional<Admin> findUser(int id) {
		return adminRepository.findById(id);
	}
	
	public void deleteUser(Admin admin) {
		adminRepository.delete(admin);
	}
}
