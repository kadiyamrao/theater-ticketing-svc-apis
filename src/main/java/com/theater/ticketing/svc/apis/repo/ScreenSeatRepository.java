package com.theater.ticketing.svc.apis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.theater.ticketing.svc.apis.dao.entity.ScreenSeatEntity;

public interface ScreenSeatRepository extends JpaRepository<ScreenSeatEntity, String> {
	
	@Query("SELECT ss.count FROM ScreenSeatEntity ss WHERE ss.screenId = :screenId  AND ss.seatType = :seatType")
	public int getSeatCountforAScreenAndSeatType(@Param("screenId") String screenId, @Param("seatType") String seatType);
}
