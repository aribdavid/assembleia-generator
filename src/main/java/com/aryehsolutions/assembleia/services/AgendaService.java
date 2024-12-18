package com.aryehsolutions.assembleia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aryehsolutions.assembleia.entities.Agenda;
import com.aryehsolutions.assembleia.entities.User;
import com.aryehsolutions.assembleia.repositories.AgendaRepository;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository repository;
	
	public List<Agenda> findAll(){
		return repository.findAll();
	}
	
	public Agenda findById(Long id) {
		Optional<Agenda> obj = repository.findById(id);
		return obj.get();
	}

}
