package com.theater.ticketing.svc.apis.dto;

import java.util.List;

import com.theater.ticketing.svc.apis.dao.entity.ScreenEntity;

public class ScreenDTO {
	private String id;
	private String name;
	private String theaterId;
	// active, inactive
	private String status;
	private List<ScreenSeatDTO> screenSeats;
	
	public ScreenDTO() {
		super();
	}
	
	public ScreenDTO(ScreenEntity screenEntity) {
		this.id = screenEntity.getId();
		this.name = screenEntity.getName();
		this.theaterId = screenEntity.getTheaterId();
		this.status = screenEntity.getStatus();
	}
	
	public ScreenDTO(String id, String name, String theaterId, String status) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public List<ScreenSeatDTO> getScreenSeats() {
		return screenSeats;
	}

	public void setScreenSeats(List<ScreenSeatDTO> screenSeats) {
		this.screenSeats = screenSeats;
	}
	
}
