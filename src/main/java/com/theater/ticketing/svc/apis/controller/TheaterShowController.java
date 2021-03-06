package com.theater.ticketing.svc.apis.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theater.ticketing.svc.apis.dto.TheaterRunningShowDTO;
import com.theater.ticketing.svc.apis.dto.TheaterShowDTO;
import com.theater.ticketing.svc.apis.services.TheaterShowService;

@RestController
@RequestMapping("/api/theater-show")
public class TheaterShowController {
	
	@Autowired
	private TheaterShowService theaterShowService;
		
	@PostMapping("/")
	public ResponseEntity<TheaterShowDTO> addTheaterShow(@RequestBody TheaterShowDTO theaterShowDTO) {
		try {
			theaterShowService.add(theaterShowDTO);
			return new ResponseEntity<>(theaterShowDTO, HttpStatus.CREATED);
		}
		catch(ConstraintViolationException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<TheaterShowDTO> updateTheaterShow(@RequestBody TheaterShowDTO theaterShowDTO) {
		try {
			theaterShowService.update(theaterShowDTO);
			return new ResponseEntity<>(theaterShowDTO, HttpStatus.OK);
		}
		catch(ConstraintViolationException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TheaterShowDTO> deleteTheaterShow(@PathVariable("id") String id) {
		try {
			theaterShowService.delete(id);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<TheaterShowDTO> getTheater(@PathVariable("id") String id) {		
		Optional<TheaterShowDTO> theaterShowDTOData = theaterShowService.getByID(id);
		
		if (theaterShowDTOData.isPresent()) {
			return new ResponseEntity<>(theaterShowDTOData.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}/mark-active")
	public ResponseEntity<TheaterShowDTO> markTheaterActive(@PathVariable("id") String id) {		
		try {
			theaterShowService.setStatus(id, "active");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}/mark-inactive")
	public ResponseEntity<TheaterShowDTO> markTheaterInactive(@PathVariable("id") String id) {		
		try {
			theaterShowService.setStatus(id, "inactive");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/running-show")
	public ResponseEntity<List<TheaterRunningShowDTO>> getShows(@RequestParam ("movieId") String movieId, 
			@RequestParam ("city") String city, @RequestParam ("date") String movieDate) {		
		return new ResponseEntity<>(theaterShowService.getAllTheaterShowsForMovieAndDateAfter(movieId, city, movieDate), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<TheaterShowDTO>> getAllTheaters() {		
		return new ResponseEntity<>(theaterShowService.getAllTheaterShows(), HttpStatus.OK);
	}
}
