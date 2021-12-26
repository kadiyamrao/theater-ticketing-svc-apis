package com.theater.ticketing.svc.apis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theater.ticketing.svc.apis.dao.entity.TheaterEntity;

public interface TheaterRepository extends JpaRepository<TheaterEntity, String> {
	
}
