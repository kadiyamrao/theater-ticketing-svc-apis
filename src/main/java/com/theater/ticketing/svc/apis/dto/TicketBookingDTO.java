package com.theater.ticketing.svc.apis.dto;

import java.util.List;

import com.theater.ticketing.svc.apis.dao.entity.TicketBookingEntity;

public class TicketBookingDTO extends BaseBookingDTO {
	private String id;
	
	private String movieId;
	
	private String screenId;
	
	private String date;
	
	private String showTime;

	private List<BaseSeatDTO> selctedSeats;
	
	public TicketBookingDTO() {
		super();
	}
	
	public TicketBookingDTO(TicketBookingEntity ticketBookingEntity) {
		super();
		this.id = ticketBookingEntity.getId();
		this.movieId = ticketBookingEntity.getMovieId();
		this.screenId = ticketBookingEntity.getScreenId();
		this.date = ticketBookingEntity.getDate();
		this.showTime = ticketBookingEntity.getShowTime();
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

	public List<BaseSeatDTO> getSelctedSeats() {
		return selctedSeats;
	}

	public void setSelctedSeats(List<BaseSeatDTO> selctedSeats) {
		this.selctedSeats = selctedSeats;
	}
}
