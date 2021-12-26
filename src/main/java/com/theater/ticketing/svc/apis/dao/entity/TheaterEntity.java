package com.theater.ticketing.svc.apis.dao.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.theater.ticketing.svc.apis.dto.TheaterDTO;

@Entity
@Table(name="theater")
public class TheaterEntity {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="address")
	private String address;
	
	// active, inactive
	@Column(name="status")
	private String status;
	
	public TheaterEntity()
	{
		
	}
	
	public TheaterEntity(TheaterDTO theaterDTO) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = theaterDTO.getName();
		this.city = theaterDTO.getCity();
		this.state = theaterDTO.getState();
		this.address = theaterDTO.getAddress();
		this.status = "active";
	}
	
	public TheaterEntity(String id, String name, String city, String state, String address, String status) {
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
	
}
