package com.theater.ticketing.svc.apis.dao.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.theater.ticketing.svc.apis.dto.TheaterShowDTO;

@Entity
@Table(name="theater_show")
public class TheaterShowEntity {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column(name="movie_id")
	private String movieId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="start_time")
	private String startTime;
	
	@Column(name="screen_id")
	private String screenId;
	
	// active, inactive
	@Column(name="status")
	private String status;
	
	public TheaterShowEntity()
	{
		
	}
	
	public TheaterShowEntity(TheaterShowDTO theaterShowDTO) {
		super();
		this.id = UUID.randomUUID().toString();
		this.movieId = theaterShowDTO.getMovieId();
		this.date = theaterShowDTO.getDate();
		this.startTime = theaterShowDTO.getStartTime();
		this.screenId = theaterShowDTO.getScreenId();
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
