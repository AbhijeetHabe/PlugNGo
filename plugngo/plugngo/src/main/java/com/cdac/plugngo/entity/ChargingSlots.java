package com.cdac.plugngo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ChargingSlots {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Long station_id;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "slot_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ChargingStations slot_number;
	
	private String availability;
	
	private LocalDateTime charging_time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStation_id() {
		return station_id;
	}

	public void setStation_id(Long station_id) {
		this.station_id = station_id;
	}

	public ChargingStations getSlot_number() {
		return slot_number;
	}

	public void setSlot_number(ChargingStations slot_number) {
		this.slot_number = slot_number;
	}

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
}
