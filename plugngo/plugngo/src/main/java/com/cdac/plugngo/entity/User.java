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
public class User {
	
	public User() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	private String user_name;
	
	private String user_location;
	
	private long user_contact;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<ChargingLog> chargingLogList;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_location() {
		return user_location;
	}

	public void setUser_location(String user_location) {
		this.user_location = user_location;
	}

	public long getUser_contact() {
		return user_contact;
	}

	public void setUser_contact(long user_contact) {
		this.user_contact = user_contact;
	}

	public List<ChargingLog> getChargingLogList() {
		return chargingLogList;
	}

	public void setChargingLogList(List<ChargingLog> chargingLogList) {
		this.chargingLogList = chargingLogList;
	}
}
