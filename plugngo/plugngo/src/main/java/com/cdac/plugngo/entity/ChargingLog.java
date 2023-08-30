package com.cdac.plugngo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ChargingLog {

	public ChargingLog() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int log_id;
	
	private LocalDateTime start_time;
	
	private LocalDateTime end_time;
	
	@ManyToOne
	@JoinColumn(name = "slot_id")
	private ChargingSlot slot;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public LocalDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}

	public LocalDateTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}

	public ChargingSlot getSlot() {
		return slot;
	}

	public void setSlot(ChargingSlot slot) {
		this.slot = slot;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
