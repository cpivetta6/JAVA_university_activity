package com.caiopivetta6.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.caiopivetta6.domain.Participant;
import com.caiopivetta6.repositories.ParticipantRepository;
import com.caiopivetta6.resources.exception.ResourceNotFoundException;
import com.caiopivetta6.services.exceptions.DatabaseException;
import com.caiopivetta6.services.exceptions.ObjectNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepository repository;
	
	public Participant find(Integer id) {
		Optional<Participant> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Tipo: " + Participant.class.getName()));
	}
	
	public Participant insert(Participant obj) {
		repository.save(obj);
		return obj;
	}
	
	public void delete(Integer id) {
		try {
		repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Participant update(Integer id, Participant obj) {
		try {
		Participant entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	private void updateData(Participant entity, Participant obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		//entity.setPhone(obj.getPhone());
	}
	
}
