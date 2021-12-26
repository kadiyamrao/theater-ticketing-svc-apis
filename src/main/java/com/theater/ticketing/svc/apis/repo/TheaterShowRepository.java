package com.theater.ticketing.svc.apis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theater.ticketing.svc.apis.dao.entity.TheaterShowEntity;

public interface TheaterShowRepository extends JpaRepository<TheaterShowEntity, String> {
	
}
