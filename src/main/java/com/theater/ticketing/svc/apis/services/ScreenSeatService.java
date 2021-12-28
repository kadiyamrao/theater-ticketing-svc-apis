package com.theater.ticketing.svc.apis.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theater.ticketing.svc.apis.dao.entity.ScreenSeatEntity;
import com.theater.ticketing.svc.apis.dto.ScreenSeatDTO;
import com.theater.ticketing.svc.apis.repo.ScreenSeatRepository;

@Service
public class ScreenSeatService {
	
	@Autowired
	private ScreenSeatRepository screenSeatRepository;
	
	@Transactional
	public void add(ScreenSeatDTO screenSeatDTO)
	{
		ScreenSeatEntity screenSeatEntity = new ScreenSeatEntity(screenSeatDTO);
		screenSeatRepository.save(screenSeatEntity);
	}
	
	public void update(ScreenSeatDTO screenSeatDTO)
	{
		ScreenSeatEntity screenSeatEntity = screenSeatRepository.getById(screenSeatDTO.getId());
		screenSeatEntity.setCount(Integer.valueOf(screenSeatDTO.getCount()));
		screenSeatEntity.setSeatType(screenSeatDTO.getSeatType());
		screenSeatEntity.setStatus(screenSeatDTO.getStatus());
		screenSeatRepository.save(screenSeatEntity);
	}
	
	public Optional<ScreenSeatDTO> getByID(String id) {
		ScreenSeatEntity screenSeatEntity = screenSeatRepository.getById(id);
		ScreenSeatDTO screenSeatDTO = null;
		if (screenSeatEntity != null)
		{
			screenSeatDTO = new ScreenSeatDTO(screenSeatEntity);
		}
		return Optional.ofNullable(screenSeatDTO);
	}
	
	public List<ScreenSeatDTO> getScreenSeatsForAScreen(String screenId)
	{
		return screenSeatRepository.findAll().stream()
				.filter(screenSearEntity -> screenSearEntity.getScreenId().equals(screenId))
				.map(ScreenSeatDTO::new).collect(Collectors.toList());
	}

	public int getSeatCountforAScreenAndSeatType(String screenId, String seatType)
	{
		return screenSeatRepository.getSeatCountforAScreenAndSeatType(screenId, seatType);
	}
	
}
