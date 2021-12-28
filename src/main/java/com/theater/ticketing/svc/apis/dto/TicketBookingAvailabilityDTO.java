package com.theater.ticketing.svc.apis.dto;

import java.util.List;

import com.theater.ticketing.svc.apis.dao.entity.TicketBookingEntity;

public class TicketBookingAvailabilityDTO extends BaseBookingDTO {
	
	private List<BaseSeatDTO> seats;
	
	public TicketBookingAvailabilityDTO() {
		super();
	}
	
	public TicketBookingAvailabilityDTO(TicketBookingEntity ticketBookingEntity) {
		super();
		this.id = ticketBookingEntity.getId();
		this.movieId = ticketBookingEntity.getMovieId();
		this.screenId = ticketBookingEntity.getScreenId();
		this.date = ticketBookingEntity.getDate();
		this.showTime = ticketBookingEntity.getShowTime();
	}
	
	public TicketBookingAvailabilityDTO(String movieId, String screenId, String date, String showTime) {
		super(null, movieId, screenId, date, showTime);
		// TODO Auto-generated constructor stub
	}

	public List<BaseSeatDTO> getSeats() {
		return seats;
	}

	public void setSeats(List<BaseSeatDTO> seats) {
		this.seats = seats;
	}
	
}
