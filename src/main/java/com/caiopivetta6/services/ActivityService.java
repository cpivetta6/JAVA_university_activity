package com.caiopivetta6.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiopivetta6.domain.Activity;
import com.caiopivetta6.repositories.ActivityRepository;
import com.caiopivetta6.resources.exceptions.ObjectNotFoundException;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository repository;
	
	public Activity find(Integer id) {
		Optional<Activity> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Tipo: " + Activity.class.getName()));
	}
	
}
