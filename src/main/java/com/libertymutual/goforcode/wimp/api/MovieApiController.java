package com.libertymutual.goforcode.wimp.api;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.dao.EmptyResultDataAccessException;


import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.MovieRepository;

	@RestController 
	@RequestMapping("/api/movies")
	public class MovieApiController {
	 
		private MovieRepository movieRepo;
		public MovieApiController(MovieRepository movieRepo ) {
			this.movieRepo = movieRepo;
			Movie movie = new Movie();
			movie.setTitle("Titanic");
			movie.setDistributor("Sony");
			movieRepo.save(movie);
		}
		@GetMapping ("{id}")
		public Movie getOne(@PathVariable long id) {
			return movieRepo.findOne(id);
		}
		
		@GetMapping ("")
		public List<Movie> getAll(){
			return movieRepo.findAll();
		}
		@DeleteMapping("{id}")
		public Movie delete(@PathVariable long id) {
			try {
				Movie movie = movieRepo.findOne(id);
				movieRepo.delete(id);
				return movie;
			} catch (EmptyResultDataAccessException erdae) {
				return null;
			
			}
		}
		@PostMapping("")
		public Movie create (@RequestBody Movie movie) {
			return movieRepo.save(movie);
		}
		
		@PutMapping("{id}") 
		public Movie update(@RequestBody Movie movie, @PathVariable long id) {
			movie.setId(id);
			return movieRepo.save(movie);
		}
		
	}

