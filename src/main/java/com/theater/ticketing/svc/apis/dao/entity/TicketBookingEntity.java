package com.theater.ticketing.svc.apis.dao.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.theater.ticketing.svc.apis.dto.TicketBookingDTO;

@Entity
@Table(name="ticket_booking")
public class TicketBookingEntity {
	@Id
	private String id;
	
	@Column(name="movie_id")
	private String movieId;
	
	@Column(name="screen_id")
	private String screenId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="show_time")
	private String showTime;

	@Column(name="seat_type")
	private String seatType;
	
	@Column(name="ticket_count")
	private int ticketCount;
	
	// active, inactive
	@Column(name="status")
	private String status;
	
	public TicketBookingEntity()
	{
		
	}
	
	public TicketBookingEntity(TicketBookingDTO ticketBookingDTO) {
		super();
		this.id = UUID.randomUUID().toString();
		this.movieId = ticketBookingDTO.getMovieId();
		this.screenId = ticketBookingDTO.getScreenId();
		this.date = ticketBookingDTO.getDate();
		this.showTime = ticketBookingDTO.getShowTime();
		this.ticketCount = ticketBookingDTO.getSelctedSeats().get(0).getCount();
		this.status = "active";
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

	public int getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	
	
}
