package com.theater.ticketing.svc.apis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theater.ticketing.svc.apis.dto.TheaterDTO;
import com.theater.ticketing.svc.apis.services.TheaterService;

@RestController
@RequestMapping("/api/theater")
public class TheaterController {
	
	@Autowired
	private TheaterService theaterService;
		
	@PostMapping("/")
	public ResponseEntity<TheaterDTO> addTheater(@RequestBody TheaterDTO theaterDTO) {
		try {
			theaterService.add(theaterDTO);
			return new ResponseEntity<>(theaterDTO, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<TheaterDTO> getTheater(@PathVariable("id") String id) {		
		Optional<TheaterDTO> theaterDTOData = theaterService.getByID(id);
		
		if (theaterDTOData.isPresent()) {
			return new ResponseEntity<>(theaterDTOData.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}/mark-active")
	public ResponseEntity<TheaterDTO> markTheaterActive(@PathVariable("id") String id) {		
		try {
			theaterService.setStatus(id, "active");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}/mark-inactive")
	public ResponseEntity<TheaterDTO> markTheaterInactive(@PathVariable("id") String id) {		
		try {
			theaterService.setStatus(id, "inactive");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<TheaterDTO>> getAllTheaters() {		
		return new ResponseEntity<>(theaterService.getAllTheaters(), HttpStatus.OK);
	}
}
