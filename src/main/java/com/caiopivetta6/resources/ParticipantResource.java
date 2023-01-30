package com.caiopivetta6.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.caiopivetta6.domain.Participant;
import com.caiopivetta6.services.ParticipantService;

@RestController
@RequestMapping(value = "participant")
public class ParticipantResource {

	@Autowired
	private ParticipantService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Participant> findById (@PathVariable Integer id){
		
		Participant obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Participant> insert (@RequestBody Participant obj){
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Participant> update (@PathVariable Integer id, @RequestBody Participant obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
