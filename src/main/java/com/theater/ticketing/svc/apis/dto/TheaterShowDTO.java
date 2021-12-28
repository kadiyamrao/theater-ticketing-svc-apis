package com.theater.ticketing.svc.apis.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.theater.ticketing.svc.apis.dao.entity.TheaterShowEntity;

public class TheaterShowDTO {
	private String id;
	@NotNull
	private String movieId;
	@NotNull
	private Date startDate;
	@NotNull
	private Date endDate;
	@NotNull
	private String startTime;
	@NotNull
	private String screenId;
	private String status;
	
	public TheaterShowDTO() {
		super();
	}
	
	public TheaterShowDTO(TheaterShowEntity theaterShowEntity) {
		super();
		this.id = theaterShowEntity.getId();
		this.movieId = theaterShowEntity.getMovieId();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
		
		try
		{
			this.startDate = sdf.parse(theaterShowEntity.getStartDate());
			this.endDate = sdf.parse(theaterShowEntity.getEndDate());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		this.startTime = theaterShowEntity.getStartTime();
		this.screenId = theaterShowEntity.getScreenId();
		this.status = theaterShowEntity.getStatus();
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
