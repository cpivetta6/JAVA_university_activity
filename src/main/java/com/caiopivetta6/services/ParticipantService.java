package com.caiopivetta6.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiopivetta6.domain.Participant;
import com.caiopivetta6.repositories.ParticipantRepository;
import com.caiopivetta6.resources.exceptions.ObjectNotFoundException;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepository repository;
	
	public Participant find(Integer id) {
		Optional<Participant> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Tipo: " + Participant.class.getName()));
	}
	
}
