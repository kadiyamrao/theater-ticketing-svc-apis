package com.theater.ticketing.svc.apis.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.ticketing.svc.apis.dao.entity.TheaterShowEntity;
import com.theater.ticketing.svc.apis.dto.MovieDTO;
import com.theater.ticketing.svc.apis.dto.ScreenDTO;
import com.theater.ticketing.svc.apis.dto.TheaterRunningShowDTO;
import com.theater.ticketing.svc.apis.dto.TheaterShowDTO;
import com.theater.ticketing.svc.apis.repo.TheaterShowRepository;

@Service
public class TheaterShowService {
	
	@Autowired
	private TheaterShowRepository theaterShowRepository;
	
	@Autowired
	private ScreenService screenService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private TheaterService theaterService;

	
	public void add(TheaterShowDTO theaterShowDTO)
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	    Set<ConstraintViolation<TheaterShowDTO>> violations = validator.validate(theaterShowDTO);
	    if (!violations.isEmpty()) {
	    	System.err.println("ERROR");
	      throw new ConstraintViolationException(violations);
	    }
		
		TheaterShowEntity theaterShowEntity = new TheaterShowEntity(theaterShowDTO);
		theaterShowRepository.save(theaterShowEntity);
	}
	
	public void update(TheaterShowDTO theaterShowDTO)
	{
		TheaterShowEntity theaterShowEntity = new TheaterShowEntity(theaterShowDTO);
		theaterShowRepository.save(theaterShowEntity);
	}
	
	public void delete(String id)
	{
		TheaterShowEntity theaterShowEntity = theaterShowRepository.getById(id);
		theaterShowRepository.delete(theaterShowEntity);
	}
	
	public void setStatus(String id, String status)
	{
		TheaterShowEntity theaterShowEntity = theaterShowRepository.getById(id);
		theaterShowEntity.setStatus(status);
		theaterShowRepository.save(theaterShowEntity);
	}
	
	public Optional<TheaterShowDTO> getByID(String id) {
		TheaterShowEntity theaterShowEntity = theaterShowRepository.getById(id);
		TheaterShowDTO theaterShowDTO = null;
		if (theaterShowEntity != null)
		{
			theaterShowDTO = new TheaterShowDTO(theaterShowEntity);
		}
		return Optional.ofNullable(theaterShowDTO);
	}
	
	Predicate<TheaterShowDTO> isTheaterShowAvalable = theaterShowDTO -> {
		return true;
	};
		
	public List<TheaterShowDTO> getAllTheaterShows()
	{
		List<TheaterShowEntity> theaterShows = theaterShowRepository.findAll();
		return theaterShows.stream().map(TheaterShowDTO::new).collect(Collectors.toList());		
	}
	
	// Return the list of shows running for a movie on & after the given date 
	public List<TheaterRunningShowDTO> getAllTheaterShowsForMovieAndDateAfter(String movieId, String city, String date)
	{
		List<TheaterShowEntity> theaterShows = theaterShowRepository.findAll()
				.stream().filter(
						theaterShowEntity -> 
							theaterShowEntity.getMovieId().equals(movieId)
							&& isDateFallInBetween(theaterShowEntity.getStartDate(), theaterShowEntity.getEndDate(), date)).collect(Collectors.toList());
		
		List<TheaterRunningShowDTO> runningShows = new ArrayList<>();
		
		for (Iterator<TheaterShowEntity> iterator = theaterShows.iterator(); iterator.hasNext();) {
			TheaterShowEntity theaterShowEntity = iterator.next();
			
			TheaterRunningShowDTO theaterRunningShowDTO = new TheaterRunningShowDTO();
			MovieDTO movieDTO = movieService.getByID(theaterShowEntity.getMovieId()).get();
			theaterRunningShowDTO.setMovieName(movieDTO.getName());
			theaterRunningShowDTO.setCity(city);
			theaterRunningShowDTO.setDate(date);
			theaterRunningShowDTO.setStartTime(theaterShowEntity.getStartTime().substring(0, 5));
			
			ScreenDTO screenDTO = screenService.getByID(theaterShowEntity.getScreenId()).get();
			
			theaterRunningShowDTO.setScreenName(screenDTO.getName());
			theaterRunningShowDTO.setTheaterName(theaterService.getByID(screenDTO.getTheaterId()).get().getName());
			runningShows.add(theaterRunningShowDTO);
		}
		
		return runningShows;		
	}
	
	private static boolean isDateFallInBetween(String startDate, String endDate, String date)
	{	
		LocalDate startLocalDate = LocalDate.parse(startDate);
		LocalDate endLocalDate = LocalDate.parse(endDate);
		LocalDate localDate = LocalDate.parse(date);
				
		return startLocalDate.isEqual(localDate) || endLocalDate.isEqual(localDate) 
				|| (localDate.isAfter(startLocalDate) && localDate.isBefore(endLocalDate));
		
	}
}
