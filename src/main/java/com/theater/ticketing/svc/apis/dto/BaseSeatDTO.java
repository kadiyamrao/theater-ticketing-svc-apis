package com.theater.ticketing.svc.apis.dto;

public class BaseSeatDTO {
	protected String id;
	protected String seatType;
	protected int count;
	
	public BaseSeatDTO() {
		super();
	}

	public BaseSeatDTO(String id, String seatType, int count) {
		super();
		this.id = id;
		this.seatType = seatType;
		this.count = count;
	}
	
	public BaseSeatDTO(ScreenSeatDTO screenSeatDTO) { 
		super();
		this.id = screenSeatDTO.getId();
		this.seatType = screenSeatDTO.getSeatType();
		this.count = screenSeatDTO.getCount();
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
	
}
