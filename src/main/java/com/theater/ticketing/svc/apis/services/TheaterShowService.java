package com.theater.ticketing.svc.apis.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.ticketing.svc.apis.dao.entity.TheaterShowEntity;
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

	
	public void add(TheaterShowDTO theaterShowDTO)
	{		
		TheaterShowEntity theaterShowEntity = new TheaterShowEntity(theaterShowDTO);
		theaterShowRepository.save(theaterShowEntity);
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
	
	public List<TheaterShowDTO> getAllTheaterShows()
	{
		List<TheaterShowEntity> theaterShows = theaterShowRepository.findAll();
		return theaterShows.stream().map(TheaterShowDTO::new).collect(Collectors.toList());		
	}
	
	// Return the list of shows running for a movie on & after the given date 
	public List<TheaterShowDTO> getAllTheaterShowsForMovieAndDateAfter(String movieId, String Date)
	{
		List<TheaterShowEntity> theaterShows = theaterShowRepository.findAll()
				.stream().filter(
						theaterShowEntity -> 
							theaterShowEntity.getMovieId().equals(movieId)
							&& isDateAfter(theaterShowEntity.getDate(), Date)).collect(Collectors.toList());
		return theaterShows.stream().map(TheaterShowDTO::new).collect(Collectors.toList());		
	}
	
	private static boolean isDateAfter(String firstDate, String secondDate)
	{
		return true;
	}
}
