package com.aryehsolutions.assembleia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryehsolutions.assembleia.entities.Agenda;
import com.aryehsolutions.assembleia.entities.User;
import com.aryehsolutions.assembleia.services.AgendaService;

@RestController
@RequestMapping(value = "/agendas")
public class AgendaResouce {
	
	@Autowired
	private AgendaService service;
	
	@GetMapping
	public ResponseEntity<List<Agenda>> findAll(){
		List<Agenda> list = service.findAll();
		
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Agenda> findById(@PathVariable Long id){
		Agenda obj = service.findById(id);
		return  ResponseEntity.ok().body(obj);
	}
}
