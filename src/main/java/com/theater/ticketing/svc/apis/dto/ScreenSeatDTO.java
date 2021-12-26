package com.theater.ticketing.svc.apis.dto;

import com.theater.ticketing.svc.apis.dao.entity.ScreenSeatEntity;

public class ScreenSeatDTO {
	private String id;
	private String seatType;
	private int count;
	private String screenId;
	// active, inactive
	private String status;
	
	public ScreenSeatDTO() {
		super();
	}

	public ScreenSeatDTO(ScreenSeatEntity screenSeatEntity) {
		super();
		this.id = screenSeatEntity.getId();
		this.seatType = screenSeatEntity.getSeatType();
		this.count = Integer.parseInt(screenSeatEntity.getCount());
		this.screenId = screenSeatEntity.getScreenId();
		this.status = screenSeatEntity.getStatus();
	}
	
	public ScreenSeatDTO(String id, String seatType, int count, String screenId, String status) {
		super();
		this.id = id;
		this.seatType = seatType;
		this.count = count;
		this.screenId = screenId;
		this.status = status;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
