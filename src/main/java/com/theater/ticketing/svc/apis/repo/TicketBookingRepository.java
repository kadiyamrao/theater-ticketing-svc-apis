package com.theater.ticketing.svc.apis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theater.ticketing.svc.apis.dao.entity.TicketBookingEntity;

public interface TicketBookingRepository extends JpaRepository<TicketBookingEntity, String> {
	
	@Query("SELECT SUM(tb) FROM TicketBookingEntity tb WHERE tb.movieId LIKE %?1%"
            + " AND tb.screenId LIKE %?2%"
            + " AND tb.date LIKE %?3%"
            + " AND tb.showTime LIKE %?4%"
            + " AND tb.seatType LIKE %?5%")
	public int getBookedSeatCount(String movieId, String screenId, String date, String showTime, String seatType);
}
