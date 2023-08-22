package com.cdac.plugngo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ChargingStations {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long station_id;
	
	private long contact;
	
	private String station_name;
	
	private String address;
	
	private byte[] image_data;
	
	private int total_slots;
	
	public Long getStation_id() {
		return station_id;
	}

	public void setStation_id(Long station_id) {
		this.station_id = station_id;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getImage_data() {
		return image_data;
	}

	public void setImage_data(byte[] image_data) {
		this.image_data = image_data;
	}

	public int getTotal_slots() {
		return total_slots;
	}

	public void setTotal_slots(int total_slots) {
		this.total_slots = total_slots;
	}
}
