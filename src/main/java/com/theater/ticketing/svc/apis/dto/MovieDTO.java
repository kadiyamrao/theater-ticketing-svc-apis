package com.theater.ticketing.svc.apis.dto;

import com.theater.ticketing.svc.apis.dao.entity.MovieEntity;

public class MovieDTO {
	private String id;
	private String name;
	private String sensorCode;
	private String language;
	private String type;
	private String synopsis;
	private String status;
	
	public MovieDTO() {
		super();
	}
	
	public MovieDTO(MovieEntity movieEntiry) {
		super();
		this.id = movieEntiry.getId();
		this.name = movieEntiry.getName();
		this.sensorCode = movieEntiry.getSensorCode();
		this.language = movieEntiry.getLanguage();
		this.type = movieEntiry.getType();
		this.synopsis = movieEntiry.getSynopsis();
		this.status = movieEntiry.getStatus();
	}
	
	public MovieDTO(String id, String name, String sensorCode, String language, String type, String synopsis,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.sensorCode = sensorCode;
		this.language = language;
		this.type = type;
		this.synopsis = synopsis;
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
