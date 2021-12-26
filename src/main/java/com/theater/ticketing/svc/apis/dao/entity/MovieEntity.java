package com.theater.ticketing.svc.apis.dao.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.theater.ticketing.svc.apis.dto.MovieDTO;

@Entity
@Table(name="movie")
public class MovieEntity {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="sensor_code")
	private String sensorCode;
	
	@Column(name="language")
	private String language;
	
	@Column(name="type")
	private String type;

	@Column(name="synopsis")
	private String synopsis;
	
	// active, inactive
	@Column(name="status")
	private String status;
	
	public MovieEntity()
	{
		
	}
	
	public MovieEntity(MovieDTO movieDTO) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = movieDTO.getName();
		this.sensorCode = movieDTO.getSensorCode();
		this.language = movieDTO.getLanguage();
		this.type = movieDTO.getType();
		this.synopsis = movieDTO.getSynopsis();
		this.status = "active";
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

	public String getSensorCode() {
		return sensorCode;
	}

	public void setSensorCode(String sensorCode) {
		this.sensorCode = sensorCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
