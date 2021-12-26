package com.theater.ticketing.svc.apis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theater.ticketing.svc.apis.dao.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, String> {
	
}
