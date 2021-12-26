package com.theater.ticketing.svc.apis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.ticketing.svc.apis.dao.entity.TheaterEntity;
import com.theater.ticketing.svc.apis.dto.TheaterDTO;
import com.theater.ticketing.svc.apis.repo.TheaterRepository;

@Service
public class TheaterService {
	
	private List<TheaterDTO> theaters = new ArrayList<>();
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Autowired
	private ScreenService screenService;
	
	public TheaterService() {
		TheaterDTO theDTO = new TheaterDTO("1", "SVC Cinemas", "HYD", "TELANGANA", "Main Road, Patanacheru, Telangana - 500019", "active");
		TheaterDTO theDTO1 = new TheaterDTO("2", "Cine Town", "HYD", "TELANGANA", "Miyapur Main Road, NH5, Telangana - 500047", "active");
		TheaterDTO theDTO2 = new TheaterDTO("3", "Hollywood-Bollywood", "HYD", "TELANGANA", "Gachibowli, Telangana - 500015", "active");
		TheaterDTO theDTO3 = new TheaterDTO("4", "INox", "HYD", "TELANGANA", "Chandanagar, National high way, Telangana - 500027", "active");
		TheaterDTO theDTO4 = new TheaterDTO("5", "Cine Police", "HYD", "TELANGANA", "Kothaguda Junction, Kondapur, Telangana - 500019", "active");
		TheaterDTO theDTO5 = new TheaterDTO("6", "AMB Cinemas", "HYD", "TELANGANA", "Serilingampally Main Road, BHEL, Telangana - 500019", "active");
		theaters.add(theDTO);
		theaters.add(theDTO1);
		theaters.add(theDTO2);
		theaters.add(theDTO3);
		theaters.add(theDTO4);
		theaters.add(theDTO5);
	}
	
	public void add(TheaterDTO theaterDTO)
	{		
		TheaterEntity theaterEntity = new TheaterEntity(theaterDTO);
		theaterRepository.save(theaterEntity);
	}
	
	public void setStatus(String id, String status)
	{
		TheaterEntity theaterEntity = theaterRepository.getById(id);
		theaterEntity.setStatus(status);
		theaterRepository.save(theaterEntity);
	}
	
	public Optional<TheaterDTO> getByID(String id) {
		TheaterEntity theaterEntity = theaterRepository.getById(id);
		TheaterDTO theaterDTO = null;
		if (theaterEntity != null)
		{
			theaterDTO = new TheaterDTO(theaterEntity);
			theaterDTO.setScreens(screenService.getScreensForATheater(theaterDTO.getId()));
		}
		return Optional.ofNullable(theaterDTO);
	}
	
	public List<TheaterDTO> getAllTheaters()
	{
		List<TheaterEntity> theaters = theaterRepository.findAll();
		return theaters.stream().map(TheaterDTO::new).collect(Collectors.toList());		
	}
}
