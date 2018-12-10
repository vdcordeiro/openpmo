package com.openpmoapi.resource;


import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.event.FeatureCreatedEvent;
import com.openpmoapi.model.Actor;
import com.openpmoapi.repository.ActorRepository;
import com.openpmoapi.service.ActorService;

import io.swagger.annotations.Api;



@RestController
@RequestMapping("/api/actor")
@Api(value = "/api/actor",  tags = "Actor",description=" ")
public class ActorResource {
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private ActorService actorService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Actor
	 * 
	 * @param id
	 *			This is the id that will be deleted 
	 *        
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		actorRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update Actor
	 * @param id
	 * 			This is the id of the actor
	 * 
	 * @param actor
	 * 			This is the collection of Actor 
	 * 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Actor> update(@PathVariable Long id, @Valid @RequestBody Actor actor) {
		Actor savedActor = actorService.update(id, actor);
		return ResponseEntity.ok(savedActor);
	}
	
	/**
	 * 
	 * This is method save Actor
	 * 
	 * @param actor
	 * 			This is the collection of Actor
	 * 
	 * @param response
	 * 			This is the answer of the HttpServletResponse
	 * 
	 */
	@PostMapping
	public ResponseEntity<Actor> save(@Valid @RequestBody Actor actor, HttpServletResponse response) {
		Actor savedActor = actorRepository.save(actor);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedActor.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(actorRepository.save(actor));
	}
	
	
	/**
	 * This method find by all Actor
	 */
	@GetMapping
	public Iterable<Actor> findByAll() {
		return actorRepository.findAll();
	}
	
	
	/**
	 *	This is method find by one Actor
	 *	
	 *	@param id
	 *			This is the id of the actor you want to find
	 *
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Actor> findById(@PathVariable Long id) {
		Optional<Actor> actor = actorRepository.findById(id);
		return actor.isPresent() ? ResponseEntity.ok(actor.get()) : ResponseEntity.notFound().build();
	}
	
	

	
}
