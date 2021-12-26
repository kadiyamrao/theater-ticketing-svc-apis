package com.theater.ticketing.svc.apis.dto;

import com.theater.ticketing.svc.apis.dao.entity.TheaterShowEntity;

public class TheaterShowDTO {
	private String id;
	private String movieId;
	private String date;
	private String startTime;
	private String screenId;
	private String status;
	
	public TheaterShowDTO() {
		super();
	}
	
	public TheaterShowDTO(TheaterShowEntity theaterShowEntiry) {
		super();
		this.id = theaterShowEntiry.getId();
		this.movieId = theaterShowEntiry.getMovieId();
		this.date = theaterShowEntiry.getDate();
		this.startTime = theaterShowEntiry.getStartTime();
		this.screenId = theaterShowEntiry.getScreenId();
		this.status = theaterShowEntiry.getStatus();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
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
