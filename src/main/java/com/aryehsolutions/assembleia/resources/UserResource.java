package com.aryehsolutions.assembleia.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryehsolutions.assembleia.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User firstUser = new User(1L, "77077077070", "Menachem Mendel");
		
		return ResponseEntity.ok().body(firstUser);
	}
}
