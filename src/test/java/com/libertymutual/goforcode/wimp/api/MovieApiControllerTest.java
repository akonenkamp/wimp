package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.DidntFindItException;
import com.libertymutual.goforcode.wimp.repositories.MovieRepository;

public class MovieApiControllerTest {
	
	private MovieRepository movieRepo;
	private MovieApiController controls;
	private ActorRepository actorRepo;
	
	@Before
	public void setUp() {
		movieRepo = mock(MovieRepository.class);
		actorRepo = mock(ActorRepository.class);
		controls = new MovieApiController(movieRepo, actorRepo);
	}

	@Test
	public void test_get_all_returns_all_movies_rturned_by_theRepo() {
		//arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie());
		movies.add(new Movie());
		
		when(movieRepo.findAll()).thenReturn(movies);
		
		//act
		
		List<Movie> actual = controls.getAll();
		
		//assert
		assertThat(actual.size()).isEqualTo(2);
		assertThat(actual.get(0)).isSameAs(movies.get(0));
		verify(movieRepo).findAll();
	
	}
	
	@Test 
	
	public void test_get_one_returns_movie_from_repo() throws DidntFindItException {
		//arrange 
		Movie titanic = new Movie();
		when(movieRepo.findOne(454l)).thenReturn(titanic);
		
		//act
		Movie actual = controls.getOne(454l);
		
		//assert
		assertThat(actual).isSameAs(titanic);
		verify(movieRepo).findOne(454l);
	}
	
	@Test 
	public void test_getOne_throws_didntFindIt_exception_when_no_movie_found_in_repo() throws DidntFindItException {
		try { 
			controls.getOne(1l);
		
			fail("the controller didnt find it");
		} catch(DidntFindItException dfie) { 
		}
	}
	

	@Test
	
	public void test_delete_returns_movie_deleted_when_found() {
		//arrange
		Movie movie = new Movie(); 
		when(movieRepo.findOne(3l)).thenReturn(movie);
		
		//act 
		Movie actual = controls.delete(3l);
		
		//assert
		assertThat(movie).isSameAs(actual);
		verify(movieRepo).delete(3l);
		verify(movieRepo).findOne(3l);
		
	}
	
	
}
