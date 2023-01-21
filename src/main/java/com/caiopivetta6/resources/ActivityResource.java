package com.caiopivetta6.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiopivetta6.domain.Activity;
import com.caiopivetta6.services.ActivityService;

@RestController
@RequestMapping(value = "activity")
public class ActivityResource {

	@Autowired
	private ActivityService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Activity> findById (@PathVariable Integer id){
		
		Activity obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	
}
