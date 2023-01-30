package com.caiopivetta6.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
