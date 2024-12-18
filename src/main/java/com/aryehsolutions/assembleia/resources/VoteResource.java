package com.aryehsolutions.assembleia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryehsolutions.assembleia.entities.Vote;
import com.aryehsolutions.assembleia.services.VoteService;

@RestController
@RequestMapping(value = "/votes")
public class VoteResource {
	
	@Autowired
	private VoteService service;
	
	@GetMapping
	public ResponseEntity<List<Vote>> findAll(){
		List<Vote> list = service.findAll();
		
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vote> findById(@PathVariable Long id){
		Vote obj = service.findById(id);
		return  ResponseEntity.ok().body(obj);
	}
}
