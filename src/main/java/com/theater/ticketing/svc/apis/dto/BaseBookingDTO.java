package com.theater.ticketing.svc.apis.dto;

public class BaseBookingDTO {
	protected String id;
	
	protected String movieId;
	
	protected String screenId;
	
	protected String date;
	
	protected String showTime;

	public BaseBookingDTO() {
		super();
	}
	
	public BaseBookingDTO(String id, String movieId, String screenId, String date, String showTime) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.screenId = screenId;
		this.date = date;
		this.showTime = showTime;
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

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
}
