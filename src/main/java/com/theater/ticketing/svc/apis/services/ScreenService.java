package com.theater.ticketing.svc.apis.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.ticketing.svc.apis.dao.entity.ScreenEntity;
import com.theater.ticketing.svc.apis.dao.entity.ScreenSeatEntity;
import com.theater.ticketing.svc.apis.dto.ScreenDTO;
import com.theater.ticketing.svc.apis.repo.ScreenRepository;

@Service
public class ScreenService {
	
	@Autowired
	private ScreenRepository screenRepository;

	@Autowired
	private ScreenSeatService screenSeatService;

	
	public void addForATheater(String theaterId, ScreenDTO screenDTO)
	{
		screenDTO.setTheaterId(theaterId);
		ScreenEntity screenEntity = new ScreenEntity(screenDTO);
		screenRepository.save(screenEntity);
		
		screenDTO.getScreenSeats().forEach(screenSeatDTO -> {
			screenSeatService.add(screenSeatDTO);
		});
	}
	
	public void setStatus(String id, String status)
	{
		ScreenEntity screenEntity = screenRepository.getById(id);
		screenEntity.setStatus(status);
		screenRepository.save(screenEntity);
	}
	
	public Optional<ScreenDTO> getByID(String id) {
		ScreenEntity screenEntity = screenRepository.getById(id);
		ScreenDTO screenDTO = null;
		
		if (screenEntity != null)
		{
			screenDTO = new ScreenDTO(screenEntity);
			screenDTO.setScreenSeats(screenSeatService.getScreenSeatsForAScreen(id));
		}
		
		return Optional.ofNullable(screenDTO);
	}
	
	public List<ScreenDTO> getScreensForATheater(String theaterId)
	{
		List<ScreenDTO> screens =  screenRepository.findAll().stream()
				.filter(screenEntity -> screenEntity.getTheaterId().equals(theaterId))
				.map(ScreenDTO::new)
				.collect(Collectors.toList());
		
		for (ScreenDTO screenDTO : screens) {
			screenDTO.setScreenSeats(screenSeatService.getScreenSeatsForAScreen(screenDTO.getId()));
		}
		
		return screens;
	}
}
