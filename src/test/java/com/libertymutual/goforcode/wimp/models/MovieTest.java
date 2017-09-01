package com.libertymutual.goforcode.wimp.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MovieTest {
	
	private Movie movie;
	
	@Before
	public void setUp() {
		movie = new Movie();
	}

	@Test 
	public void test_setId() {
	
	//arrange
	Long id = 3l;
	movie.setId(id);
	
	//act
	Long actual = movie.getId();
	
	//assert
	assertThat(actual).isSameAs(3l);
	
	}
	
	@Test
	public void get_movie_title () {
		//arrange 
		String movieTitle = "Titanic";
		movie.setTitle(movieTitle);
		
		//act
		String actual = movie.getTitle();
		
		//assert 
		assertThat(actual).isEqualTo(movieTitle);
	}
	
	@Test
	public void tst_the_release_date() {
		
		//arrange 
		Date release = new Date(Date.parse("12/12/12"));
		movie.setReleaseDate(release);
		
		//act
		Date actualReleaseDate = movie.getReleaseDate();
		
		//assert
		assertThat(actualReleaseDate).isEqualTo(actualReleaseDate);
		
	}
	
	@Test 
	public void test_the_budget_getter() {
		//arrange 
		Long moneyAmt = 345l;
		movie.setBudget(moneyAmt);
		
		//act
		Long actual = movie.getBudget();
	
		
		//assert 
		assertThat(actual).isEqualTo(345l);
	}
	
	@Test 
	public void test_the_distributor_getter() {
		
		//arrange
		String distributor = "miramax";
		movie.setDistributor(distributor);
		//act
		String actual = movie.getDistributor();
		//assert
		assertThat(actual).isEqualTo(distributor);
	}
	
	@Test 
	public void tst_get_actors() {
		//arrange 
		ArrayList<Actor> actors = new ArrayList<Actor>();
		movie.setActors(actors);
		
		//act
		List actualActors = movie.getActors();
		
		//assert
		assertThat(actualActors).isEqualTo(actors);
	}
	
	@Test
	public void test_add_actor() {
		//arrange 
		Actor actor = new Actor();
		
		//act
		movie.addActor(actor);
		
		//assert 
		assertThat(movie.getActors()).contains(actor);
	}
}
