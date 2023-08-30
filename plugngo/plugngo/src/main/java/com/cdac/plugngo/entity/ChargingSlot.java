package com.cdac.plugngo.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ChargingSlot {
	
	public ChargingSlot() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slot_id;
	
	@ManyToOne
	@JoinColumn(name = "station_id")
	private ChargingStation station;

	private String availability;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Kolkata")
	private LocalDateTime charging_time;
	
	@JsonIgnore
	@OneToMany(mappedBy = "slot", cascade = CascadeType.ALL)
	private List<ChargingLog> chargingLogList;

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public LocalDateTime getCharging_time() {
		return charging_time;
	}

	public void setCharging_time(LocalDateTime charging_time) {
		this.charging_time = charging_time;
	}

	public int getSlot_id() {
		return slot_id;
	}

	public void setSlot_id(int slot_id) {
		this.slot_id = slot_id;
	}

	public ChargingStation getStation() {
		return station;
	}

	public void setStation(ChargingStation station) {
		this.station = station;
	}

	public List<ChargingLog> getChargingLogList() {
		return chargingLogList;
	}

	public void setChargingLogList(List<ChargingLog> chargingLogList) {
		this.chargingLogList = chargingLogList;
	}
}
