package com.theater.ticketing.svc.apis.dto;

import java.util.List;

import com.theater.ticketing.svc.apis.dao.entity.TheaterEntity;

public class TheaterDTO {
	private String id;
	private String name;
	private String city;
	private String state;
	private String address;
	private String status;
	private List<ScreenDTO> screens;
	
	public TheaterDTO() {
		super();
	}
	
	public TheaterDTO(TheaterEntity theaterEntiry) {
		super();
		this.id = theaterEntiry.getId();
		this.name = theaterEntiry.getName();
		this.city = theaterEntiry.getCity();
		this.state = theaterEntiry.getState();
		this.address = theaterEntiry.getAddress();
		this.status = theaterEntiry.getStatus();
	}
	
	public TheaterDTO(String id, String name, String city, String state, String address, String status) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.state = state;
		this.address = address;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public List<ScreenDTO> getScreens() {
		return screens;
	}

	public void setScreens(List<ScreenDTO> screens) {
		this.screens = screens;
	}
	
	
}
