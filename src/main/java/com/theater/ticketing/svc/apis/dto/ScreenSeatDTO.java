package com.theater.ticketing.svc.apis.dto;

import com.theater.ticketing.svc.apis.dao.entity.ScreenSeatEntity;

public class ScreenSeatDTO extends BaseSeatDTO {

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
		this.count = screenSeatEntity.getCount().intValue();
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
