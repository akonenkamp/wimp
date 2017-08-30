package com.libertymutual.goforcode.wimp.api;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.wimp.models.Actor;

import com.libertymutual.goforcode.wimp.repositories.ActorRepository;



@RestController 
@RequestMapping("/api/actors")
public class ActorApiController {
	private ActorRepository actorRepo;
	
	public ActorApiController(ActorRepository actorRepo) {
		this.actorRepo = actorRepo;
		Actor actor = new Actor();
		actor.setFirstName("Alec");
		actor.setLastName("Baldwin");
		actorRepo.save(actor);
	}
	
	@GetMapping("{id}")
	public Actor getOne(@PathVariable long id) {
		return actorRepo.findOne(id);
	}
	
	@GetMapping("")
	public List<Actor> getAll(){
		return actorRepo.findAll();	
	}
	 
	@DeleteMapping("{id}")
	public Actor delete(@PathVariable long id) {
		try { 
			Actor actor = actorRepo.findOne(id);
			actorRepo.delete(id);
			return actor;
		} catch (EmptyResultDataAccessException erdae) {
			return null;
		}
	}
	
@PostMapping("")
public Actor create(@RequestBody Actor actor) {
	return actorRepo.save(actor);
}

@PutMapping("{id}")
public Actor update (@RequestBody Actor actor, @PathVariable long id) {
	actor.setId(id);
	return actorRepo.save(actor);
}

}