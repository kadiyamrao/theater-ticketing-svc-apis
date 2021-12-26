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

import com.theater.ticketing.svc.apis.dto.MovieDTO;
import com.theater.ticketing.svc.apis.services.MovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
		
	@PostMapping("/")
	public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO theaterDTO) {
		try {
			movieService.add(theaterDTO);
			return new ResponseEntity<>(theaterDTO, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> getMovie(@PathVariable("id") String id) {		
		Optional<MovieDTO> theaterDTOData = movieService.getByID(id);
		
		if (theaterDTOData.isPresent()) {
			return new ResponseEntity<>(theaterDTOData.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}/mark-active")
	public ResponseEntity<MovieDTO> markMovieActive(@PathVariable("id") String id) {		
		try {
			movieService.setStatus(id, "active");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}/mark-inactive")
	public ResponseEntity<MovieDTO> markMovieInactive(@PathVariable("id") String id) {		
		try {
			movieService.setStatus(id, "inactive");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<MovieDTO>> getAllMovies() {		
		return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
	}
}
