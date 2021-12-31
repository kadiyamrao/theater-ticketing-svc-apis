package com.theater.ticketing.svc.apis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theater.ticketing.svc.apis.dao.entity.TheaterShowEntity;

public interface TheaterShowRepository extends JpaRepository<TheaterShowEntity, String> {
	
	@Query("SELECT ts FROM TheaterShowEntity ts INNER JOIN ScreenEntity se ON (ts.screenId = se.id)"
			+ " INNER JOIN TheaterEntity te ON (se.theaterId = te.id)"
			+ " WHERE ts.movieId LIKE %?1%"
			+ " AND te.city LIKE %?2%"
            + " AND ts.startDate <= ?3"
            + " AND ts.endDate >= ?3")
	public List<TheaterShowEntity> getAllTheaterShowsInACityForMovieAndDate(String movieId, String city, String date);
}
