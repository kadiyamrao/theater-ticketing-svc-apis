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

import com.theater.ticketing.svc.apis.dto.ScreenDTO;
import com.theater.ticketing.svc.apis.services.ScreenService;

@RestController
@RequestMapping("/api/theater/{theaterId}/screen")
public class ScreenController {
	
	@Autowired
	private ScreenService screenService;
		
	@PostMapping("/")
	public ResponseEntity<ScreenDTO> addScreen(@PathVariable("theaterId") String theaterId, @RequestBody ScreenDTO screenDTO) {
		try {
			screenService.addForATheater(theaterId, screenDTO);
			return new ResponseEntity<>(screenDTO, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ScreenDTO> getScreen(@PathVariable("id") String id) {		
		Optional<ScreenDTO> screenDTOData = screenService.getByID(id);
		
		if (screenDTOData.isPresent()) {
			return new ResponseEntity<>(screenDTOData.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}/mark-active")
	public ResponseEntity<ScreenDTO> markScreenActive(@PathVariable("id") String id) {		
		try {
			screenService.setStatus(id, "active");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}/mark-inactive")
	public ResponseEntity<ScreenDTO> markScreenInactive(@PathVariable("id") String id) {		
		try {
			screenService.setStatus(id, "inactive");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ScreenDTO>> getAllScreens(@PathVariable("theaterId") String theaterId) {		
		return new ResponseEntity<>(screenService.getScreensForATheater(theaterId), HttpStatus.OK);
	}
}
