package com.aryehsolutions.assembleia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aryehsolutions.assembleia.entities.Vote;
import com.aryehsolutions.assembleia.repositories.VoteRepository;

@Service
public class VoteService {

	@Autowired
	private VoteRepository repository;
	
	public List<Vote> findAll(){
		return repository.findAll();
	}
	
	public Vote findById(Long id) {
		Optional<Vote> obj = repository.findById(id);
		return obj.get();
	}

}
