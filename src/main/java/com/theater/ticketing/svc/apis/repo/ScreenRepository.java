package com.theater.ticketing.svc.apis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theater.ticketing.svc.apis.dao.entity.ScreenEntity;

public interface ScreenRepository extends JpaRepository<ScreenEntity, String> {
	
}
