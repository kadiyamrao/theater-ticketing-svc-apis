package com.theater.ticketing.svc.apis.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theater.ticketing.svc.apis.dao.entity.MovieEntity;
import com.theater.ticketing.svc.apis.dto.MovieDTO;
import com.theater.ticketing.svc.apis.repo.MovieRepository;

@Service
public class MovieService {
		
	@Autowired
	private MovieRepository movieRepository;
	
	public void add(MovieDTO movieDTO)
	{		
		MovieEntity movieEntity = new MovieEntity(movieDTO);
		movieRepository.save(movieEntity);
	}
	
	public void setStatus(String id, String status)
	{
		MovieEntity movieEntity = movieRepository.getById(id);
		movieEntity.setStatus(status);
		movieRepository.save(movieEntity);
	}
	
	public Optional<MovieDTO> getByID(String id) {
		MovieEntity movieEntity = movieRepository.getById(id);
		MovieDTO movieDTO = null;
		if (movieEntity != null)
		{
			movieDTO = new MovieDTO(movieEntity);
		}
		return Optional.ofNullable(movieDTO);
	}
	
	public List<MovieDTO> getAllMovies()
	{
		List<MovieEntity> movies = movieRepository.findAll();
		return movies.stream().map(MovieDTO::new).collect(Collectors.toList());		
	}
}
