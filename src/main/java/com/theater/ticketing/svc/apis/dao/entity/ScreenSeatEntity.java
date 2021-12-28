package com.theater.ticketing.svc.apis.dao.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.theater.ticketing.svc.apis.dto.ScreenSeatDTO;

@Entity
@Table(name="screen_seat")
public class ScreenSeatEntity {
	
	@Id
	private String id;
	
	@Column(name="seat_type")
	private String seatType;
	
	@Column(name="screen_id")
	private String screenId;
	
	@Column(name="count")
	private Integer count;
	
	// active, inactive
	@Column(name="status")
	private String status;
	
	public ScreenSeatEntity() {
		super();
	}

	public ScreenSeatEntity(ScreenSeatDTO screenSeatDTO) {
		super();
		this.id = UUID.randomUUID().toString();
		this.seatType = screenSeatDTO.getSeatType();
		this.screenId = screenSeatDTO.getScreenId();
		this.count = Integer.valueOf(screenSeatDTO.getCount());
		this.status = screenSeatDTO.getStatus();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
