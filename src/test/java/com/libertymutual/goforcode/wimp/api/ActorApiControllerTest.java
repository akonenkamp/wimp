package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.DidntFindItException;

public class ActorApiControllerTest {
	
	private ActorRepository actorRepo;
	private ActorApiController controller;
	
	@Before 
	public void setUp() {
		actorRepo = mock(ActorRepository.class);
		controller = new ActorApiController(actorRepo);
		
	}
	
	

	@Test
	public void test_get_all_returns_all_actors() {
		//arrange
		ArrayList<Actor> actors = new ArrayList<Actor>();
		actors.add(new Actor());
		actors.add(new Actor());
		when(actorRepo.findAll()).thenReturn(actors);
		
		//act
		List<Actor> actual = controller.getAll();
		
		//assert 
		assertThat(actual.size()).isEqualTo(2);
		
		
		assertThat(actual.get(0)).isSameAs(actors.get(0));
		
		
		verify(actorRepo).findAll();
		
	
	}

	@Test 
	
	public void test_getOne_returns_actor_from_repo() throws DidntFindItException {
		//arrange 
		Actor mattDamon = new Actor();
		when(actorRepo.findOne(4555l)).thenReturn(mattDamon);
		//act
		Actor actual = controller.getOne(4555l);
		
		//assert
		assertThat(actual).isSameAs(mattDamon);
		verify(actorRepo).findOne(4555l);
		
	}
	
	@Test
	public void test_getOn_throws_stuff_not_found_when_no_actor_is_returned() {
		try {
			controller.getOne(1l);
			fail("the controller did not throw didnt find it exception");
		} catch(DidntFindItException dnfie) {}
	}
	
	@Test
	
	public void test_delete_returns_actor_when_found() {
		//arrange
		Actor actor = new Actor();
		when(actorRepo.findOne(3l)).thenReturn(actor);
		//act
		Actor actual = controller.delete(3l);
		
		//assert
		
		assertThat(actor).isSameAs(actual);
		verify(actorRepo).delete(3l);
		verify(actorRepo).findOne(3l);
		
	}
	
	@Test
	public void test_that_null_is_returned_with_didntfindit_is_thrown() throws DidntFindItException 
	{
		//arrange 
		when(actorRepo.findOne(3l)).thenThrow(new EmptyResultDataAccessException(0));
		
		//act
		Actor actual = controller.delete(8l);
		
		//assert 
		assertThat(actual).isNull();
		verify(actorRepo).findOne(8l);
		
		
	}
}
