package com.theater.ticketing.svc.apis.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TheaterRunningShowDTO {
	@JsonIgnore
	private String city;
	@JsonIgnore
	private String movieName;
	@JsonIgnore
	private String date;
	
	private String theaterName;
	@JsonIgnore
	private String screenName;
	private String startTime;
	
	public TheaterRunningShowDTO() {
		super();
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	
}
