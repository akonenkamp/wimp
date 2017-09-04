package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.libertymutual.goforcode.wimp.models.ActorWithMovies;
import com.libertymutual.goforcode.wimp.models.Movie;

public class ActorWithMovieTest {

	@Test
	public void test_that_no_really_Movies_returns_movie_list() {
		
		//arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		ActorWithMovies actorWithMovies = new ActorWithMovies();
		actorWithMovies.setMovies(movies);
		
		//act
		List<Movie> actualMovies = actorWithMovies.noReallyMovies();
		
		//assert
		assertThat(actualMovies).isSameAs(movies);
		
	}
	

}

