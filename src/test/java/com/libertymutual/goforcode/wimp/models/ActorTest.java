package com.libertymutual.goforcode.wimp.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ActorTest {
	private Actor actor;
	private Long year;

	@Before
	public void setUp() {
		actor = new Actor();

	}

	@Test
	public void test_setId() {
		// arrange
		Long id = 3l;
		actor.setId(id);

		// act
		Long actual = actor.getId();

		// assert
		assertThat(actual).isSameAs(3l);
	}

	@Test
	public void get_first_name() {
		// arrange
		// Actor actor = new Actor();
		String firstName = "james";
		actor.setFirstName(firstName);
		// act
		String actual = actor.getFirstName();
		// assert
		assertThat(actual).isEqualTo(firstName);

	}

	@Test
	public void get_last_name() {

		// arrange
		String lastName = "dean";
		actor.setLastName(lastName);

		// act
		String actual = actor.getLastName();

		// assert
		assertThat(actual).isEqualTo(lastName);
	}

	@Test
	public void test_set_get_active_year() {
		// arrange

		Long id = 1994l;
		actor.setActiveSinceYear(id);

		// act
		Long actual = actor.getActiveSinceYear();

		// assert
		assertThat(actual).isEqualTo(1994l);
	}

	@Test

	public void test_the_dob() {
		// arrange
		Date bdate = new Date(Date.parse("12/13/19"));
		actor.setBirthDate(bdate);
		
		// act
		Date actualBday = actor.getBirthDate();

		// assert
		assertThat(actualBday).isEqualTo(bdate);
	}
	
	@Test
	
	public void test_get_movies() {
		//arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		actor.setMovies(movies);
		
		//act
		
		List actualMovies = actor.getMovies();
		
		//assert 
		assertThat(actualMovies).isEqualTo(movies);
 }
}
