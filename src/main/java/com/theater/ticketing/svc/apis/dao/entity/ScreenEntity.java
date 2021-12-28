package com.theater.ticketing.svc.apis.dao.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.theater.ticketing.svc.apis.dto.ScreenDTO;

@Entity
@Table(name="screen")
public class ScreenEntity {
	
	@Id
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="theater_id")
	private String theaterId;
	
	// active, inactive
	@Column(name="status")
	private String status;
	
	public ScreenEntity() {
		super();
	}
	
	public ScreenEntity(ScreenDTO screenDTO) {
		this.id = UUID.randomUUID().toString();
		this.name = screenDTO.getName();
		this.theaterId = screenDTO.getTheaterId();
		this.status = screenDTO.getStatus();
	}
	
	public ScreenEntity(String id, String name, String theaterId, String status) {
		super();
		this.id = id;
		this.name = name;
		this.theaterId = theaterId;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
}
