package com.cdac.plugngo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ChargingStation {
	
	public ChargingStation() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int station_id;
	
	private long contact;

	private String station_name;
	
	private String address;
	
	private byte[] image_data;
	
	@JsonIgnore
	@OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
	private List<ChargingSlot> chargingSlotList;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="admin_id")
	private Admin admin;
	
	public int getStation_id() {
		return station_id;
	}

	public void setStation_id(int station_id) {
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

	public List<ChargingSlot> getChargingSlotList() {
		return chargingSlotList;
	}

	public void setChargingSlotList(List<ChargingSlot> chargingSlotList) {
		this.chargingSlotList = chargingSlotList;
	}
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
