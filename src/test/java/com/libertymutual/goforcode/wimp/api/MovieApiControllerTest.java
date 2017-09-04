package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import com.libertymutual.goforcode.wimp.models.Actor;
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
		
	}
	
	@Test
	public void test_delete_returns_catch_throw_exception() {
	
	//arrange 
		when(movieRepo.findOne(3L)).thenThrow(new EmptyResultDataAccessException(0));

	//act
		Movie actual = controls.delete(3l);
	
	//assert
		assertThat(actual).isNull();
		verify(movieRepo).findOne(3l);	
		
		}

	
	@Test
	
	public void test_the_create_a_movie_and_add_to_repo() {
		//arrange
		Movie movie = new Movie();
		when(movieRepo.save(movie)).thenReturn(movie);
		//act
		Movie actualMovie = controls.create(movie);
		
		//assert 
		assertThat(movie).isSameAs(actualMovie);
		verify(movieRepo).save(movie);
	}

	
	
	@Test
	public void test_associate_an_actor_add_an_actor_to_a_movie() {
	
		//arrange 
		Movie movie = new Movie();
		when(movieRepo.findOne(3L)).thenReturn(movie);
		Actor actor = new Actor();
//		actor.setId(2L);
		when(actorRepo.findOne(2L)).thenReturn(actor);
		
	//act
		Actor actualActor = actorRepo.findOne(2L);
//		when(actorRepo.findOne(2L)).thenReturn(newActor);
		Movie actualMovie = controls.associateAnActor(3L, actualActor);

		
	//assert
		assertThat(actualMovie).isSameAs(movie);
		assertThat(actualActor).isSameAs(actualActor);
		verify(movieRepo).save(movie);

	}
	
	@Test
	public void test_update_movies_saves_to_movie_repo() {
		//arrange 
		 Movie movie = new Movie();
		 when(movieRepo.save(movie)).thenReturn(movie);
		
		//act
		 Movie actualMovie = controls.update(movie, 3L);
		
		//assert
		 assertThat(actualMovie.getId()).isSameAs(movie.getId());
		 verify(movieRepo).save(movie);
	}
	
}





