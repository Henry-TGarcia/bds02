package com.devsuperior.bds02.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;

	public EventDTO update(Long id, EventDTO dto) {
		try {
			Event event = repository.getOne(id);
			
			event.setName(dto.getName());
			event.setDate(dto.getDate());
			event.setUrl(dto.getUrl());
			event.setCity(new City(dto.getCityId(), null));
			
			event = repository.save(event);
			
			return new EventDTO(event);
		}
		catch(EntityNotFoundException e) { //caso o id informado não exista
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

}
