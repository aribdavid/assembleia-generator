package com.aryehsolutions.assembleia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aryehsolutions.assembleia.entities.Voting;
import com.aryehsolutions.assembleia.repositories.VotingRepository;

@Service
public class VotingService {

	@Autowired
	private VotingRepository repository;
	
	public List<Voting> findAll(){
		return repository.findAll();
	}
	
	public Voting findById(Long id) {
		Optional<Voting> obj = repository.findById(id);
		return obj.get();
	}

}
