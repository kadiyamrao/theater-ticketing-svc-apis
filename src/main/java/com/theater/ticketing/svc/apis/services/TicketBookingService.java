package com.theater.ticketing.svc.apis.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.ticketing.svc.apis.dao.entity.TicketBookingEntity;
import com.theater.ticketing.svc.apis.dto.BaseBookingDTO;
import com.theater.ticketing.svc.apis.dto.BaseSeatDTO;
import com.theater.ticketing.svc.apis.dto.ScreenSeatDTO;
import com.theater.ticketing.svc.apis.dto.TheaterShowDTO;
import com.theater.ticketing.svc.apis.dto.TicketBookingAvailabilityDTO;
import com.theater.ticketing.svc.apis.dto.TicketBookingDTO;
import com.theater.ticketing.svc.apis.repo.TicketBookingRepository;

@Service
public class TicketBookingService {
	
	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	
	@Autowired
	private ScreenSeatService screenSeatService;
	
	@Autowired
	private TheaterShowService theaterShowService;
	
	
	public TicketBookingAvailabilityDTO getAvaiableTickets(BaseBookingDTO baseBookingDTO)
	{
		// Total available tickets for the show
		List<ScreenSeatDTO> screenSeatDTOs = screenSeatService.getScreenSeatsForAScreen(baseBookingDTO.getScreenId());

		
		List<BaseSeatDTO> seats = new ArrayList<>();

		// For each type of seat - get booked tickets and calculate available tickets
		Iterator<ScreenSeatDTO> iter = screenSeatDTOs.iterator();
		while(iter.hasNext())
		{
			ScreenSeatDTO screenSeatDTO = iter.next();
			BaseSeatDTO baseSeatDTO = new BaseSeatDTO(screenSeatDTO);

			int bookedSeats = ticketBookingRepository.getBookedSeatCount(baseBookingDTO.getMovieId(), 
					baseBookingDTO.getScreenId(), 
					baseBookingDTO.getDate(), 
					baseBookingDTO.getShowTime(),
					screenSeatDTO.getSeatType());

			int availableSeats = screenSeatDTO.getCount() -  bookedSeats;
			if (availableSeats > 0)
			{
				baseSeatDTO.setCount(availableSeats);
				seats.add(baseSeatDTO);
			}
		}

		TicketBookingAvailabilityDTO availabilityDTO = new TicketBookingAvailabilityDTO(
				baseBookingDTO.getMovieId(),
				baseBookingDTO.getScreenId(),
				baseBookingDTO.getDate(),
				baseBookingDTO.getShowTime());
		
		availabilityDTO.setSeats(seats);
		
		return availabilityDTO;
	}
	
	public void bookAvaiableTickets(TicketBookingDTO ticketBookingDTO)
	{
		// Check if show is valid
		TheaterShowDTO theaterShowDTO = new TheaterShowDTO();
		theaterShowDTO.setMovieId(ticketBookingDTO.getMovieId());
		theaterShowDTO.setScreenId(ticketBookingDTO.getScreenId());
		
		theaterShowDTO.setStartTime(ticketBookingDTO.getShowTime());
		theaterShowDTO.setStatus("active");

		if (!theaterShowService.isTheaterShowAvalable.test(theaterShowDTO))
		{
			// Throw error
		}
		
		if (!areTicketsAvailable(ticketBookingDTO))
		{
			// Tickets Not available
		}
		
//		TicketBookingEntity ticketBookingEntity = new TicketBookingEntity(ticketBookingDTO);
//		ticketBookingRepository.save(ticketBookingEntity);		
	}
		
	private boolean areTicketsAvailable(TicketBookingDTO ticketBookingDTO)
	{		
		for (BaseSeatDTO baseSeatDTO : ticketBookingDTO.getSelctedSeats()) {
			int bookedSeats = ticketBookingRepository.getBookedSeatCount(ticketBookingDTO.getMovieId(), 
					ticketBookingDTO.getScreenId(), 
					ticketBookingDTO.getDate(), 
					ticketBookingDTO.getShowTime(),
					baseSeatDTO.getSeatType());
			
			// Total available tickets for the show
			int totalSeats = screenSeatService.getSeatCountforAScreenAndSeatType(ticketBookingDTO.getScreenId(), baseSeatDTO.getSeatType());

			int availableSeats = totalSeats - bookedSeats;
			
			if (baseSeatDTO.getCount() < availableSeats)
			{
				return true;
			}
		}
		return false;
	}

}
