package com.aryehsolutions.assembleia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryehsolutions.assembleia.entities.Voting;
import com.aryehsolutions.assembleia.services.VotingService;

@RestController
@RequestMapping(value = "/votings")
public class VotingResource {
	
	@Autowired
	private VotingService service;
	
	@GetMapping
	public ResponseEntity<List<Voting>> findAll(){
		List<Voting> list = service.findAll();
		
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Voting> findById(@PathVariable Long id){
		Voting obj = service.findById(id);
		return  ResponseEntity.ok().body(obj);
	}
}
