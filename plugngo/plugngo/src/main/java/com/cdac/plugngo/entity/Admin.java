package com.cdac.plugngo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
	
	public Admin() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admin_id;
	
	private String admin_name;
	
	private long admin_contact;
	
	private String admin_location;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<ChargingStation> chargingStationList;

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public long getAdmin_contact() {
		return admin_contact;
	}

	public void setAdmin_contact(long admin_contact) {
		this.admin_contact = admin_contact;
	}

	public String getAdmin_location() {
		return admin_location;
	}

	public void setAdmin_location(String admin_location) {
		this.admin_location = admin_location;
	}

	public List<ChargingStation> getChargingStationList() {
		return chargingStationList;
	}

	public void setChargingStationList(List<ChargingStation> chargingStationList) {
		this.chargingStationList = chargingStationList;
	}
}
